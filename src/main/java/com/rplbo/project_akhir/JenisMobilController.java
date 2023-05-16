package com.rplbo.project_akhir;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import javafx.beans.Observable;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class JenisMobilController implements Initializable{
    @FXML
    private Button backBttn;
    
    @FXML
    private Button addJenisMobilBttn;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private TableView<JenisMobilTable> jenisMobilTable;
    
    @FXML
    private TableColumn<JenisMobilTable, String> namaMobil;
    
    @FXML
    private TableColumn<JenisMobilTable, String> merk;
    
    @FXML
    private TableColumn<JenisMobilTable, String> mesin;
    
    @FXML
    private TableColumn<JenisMobilTable, Integer> kapasitas;
    
    @FXML
    private TableColumn<JenisMobilTable, String> transmisi;
    
    @FXML
    private TableColumn<JenisMobilTable, String> jenis;
    
    @FXML
    private TableColumn<JenisMobilTable, Void> action;
    @FXML
    ObservableList<JenisMobilTable> list = FXCollections.observableArrayList(
    );

    Parent root;
    Scene scene;

    Stage stage;


    public void initialize(URL url,ResourceBundle rb){
        ObservableList<JenisMobilTable> dataJenis = FXCollections.observableArrayList(StorageJenisMobil.getListJenis());
        namaMobil.setCellValueFactory(new PropertyValueFactory<>("namaMobil"));
        merk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        mesin.setCellValueFactory(new PropertyValueFactory<>("mesin"));
        kapasitas.setCellValueFactory(new PropertyValueFactory<>("kapasitas"));
        transmisi.setCellValueFactory(new PropertyValueFactory<>("transmisi"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        jenisMobilTable.setItems(dataJenis);
        for (JenisMobilTable jenisMobil : dataJenis) {
            jenisMobil.getAction().setId(Integer.toString(jenisMobil.getId())) ;
            jenisMobil.getAction().setOnAction(e-> {
                try{
                updateInfo(e);} catch(IOException ex){}
                });
        }
        
    }
    public void updateInfo(ActionEvent event)throws IOException {
        Button btn = (Button) event.getSource();
        ObservableList<JenisMobilTable> dataMobils = FXCollections.observableArrayList(StorageJenisMobil.getListJenis());
        JenisMobilTable tempe = null;
        for (JenisMobilTable informasiMobil : dataMobils) {
            if(informasiMobil.getId() == Integer.parseInt(btn.getId())){
                System.out.println(informasiMobil.getId());
                tempe = informasiMobil;
            }
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("jenisMobilEdit.fxml"));
        root = loader.load();

        JenisMobilEdit update = loader.getController();
        update.showOldData(tempe);

        scene = new Scene(root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    public ObservableList<JenisMobilTable> getList() {
        return list;
    }
    
    
    public void toLogin(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHome.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    
    public void toAddJenisMobil(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("jenisMobilAdd.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    
    public void search() {
    
    }
    
}
