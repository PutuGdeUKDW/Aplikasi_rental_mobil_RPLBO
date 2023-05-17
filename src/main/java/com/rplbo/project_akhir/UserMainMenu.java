package com.rplbo.project_akhir;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UserMainMenu implements Initializable{
    @FXML
    private Button backButton;

    @FXML
    private TableView<InformasiMobil> tableView;

    @FXML
    private TableColumn<InformasiMobil, Integer> numberColumn;

    @FXML
    private TableColumn<InformasiMobil, String> nameColumn;

    @FXML
    private TableColumn<InformasiMobil, Double> rentalPriceColumn;

    @FXML
    private TableColumn<InformasiMobil, Button> actionColumn;

    Parent root;
    Scene scene;
    Stage stage;

    public void toBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginUser.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<InformasiMobil> tempe = FXCollections.observableArrayList();
        for (InformasiMobil i : StorageInformasiMobil.getListMobil()) {
            if(i.getStatus()==true){
                tempe.add(i);
            }
        }

        numberColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("merk"));
        rentalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("harga"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));

        tableView.setItems(tempe);
        for (InformasiMobil jenisMobil : tempe) {
            jenisMobil.getAction().setId(Integer.toString(jenisMobil.getId())) ;
            jenisMobil.getAction().setOnAction(e-> {
                try{
                rental(e);} catch(IOException ex){}
                });
        }   
    }
    public void rental(ActionEvent event)throws IOException {
        Button btn = (Button) event.getSource();
        ObservableList<InformasiMobil> dataMobils = FXCollections.observableArrayList(StorageInformasiMobil.getListMobil());
        InformasiMobil tempe = null;
        for (InformasiMobil informasiMobil : dataMobils) {
            if(informasiMobil.getId() == Integer.parseInt(btn.getId())){
                tempe = informasiMobil;
            }
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailMobil.fxml"));
        root = loader.load();

        DetailMobil update = loader.getController();
        update.showOldData(tempe);

        scene = new Scene(root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    
}
