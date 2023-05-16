package com.rplbo.project_akhir;

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
//import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable{

    Button addInformasiMobil;
    Button jenisMobilButton;

    Button backBttn;
    TextField searchbar;

    Button searchBar;
    Parent root;
    Scene scene;

    Button refresh;

    @FXML
    private TableView<InformasiMobil> tableView;

    @FXML
    private TableColumn<InformasiMobil, String> jenisMobilCol;

    @FXML
    private TableColumn<InformasiMobil, String> brandCol;

    @FXML
    private TableColumn<InformasiMobil, String> transmisiCol;

    @FXML
    private TableColumn<InformasiMobil, String> namaMobilCol;

    @FXML
    private TableColumn<InformasiMobil, String> kapasitasCol;

    @FXML
    private TableColumn<InformasiMobil, Double> hargaCol;

    @FXML
    private TableColumn<InformasiMobil, Boolean> statusCol;

    @FXML
    private TableColumn<InformasiMobil, Void> actionCol;

    Stage stage;

    JenisMobilController jenisMobilTableList = new JenisMobilController();
    ObservableList<JenisMobilTable> list = jenisMobilTableList.getList();
    
    ObservableList<InformasiMobil> data = FXCollections.observableArrayList();

    public ObservableList<InformasiMobil> getData(){
        return data;
    }

    public void addData(InformasiMobil ingpo){
        data.add(ingpo);
    }

    public void refreshData(ActionEvent event)throws IOException{
        System.out.println("AAAA");
        InformasiMobilController i = new InformasiMobilController();
        if(i.getMobil()!=null){
            data.add(i.getMobil());
            i.setMobil(null);
            System.out.println("Eeeeeeee");
        }
        for (InformasiMobil xo : data) {
            System.out.println(xo.getNamaMobil() + " , " + xo.getJenisMobil());
        }

        tableView.refresh();
    }

    public void toLogin(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }

    public void toJenis(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("jenisMobil.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }

    public void toaddInformasiMobil(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("informasiMobil.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<InformasiMobil> dataMobils = FXCollections.observableArrayList(StorageInformasiMobil.getListMobil());
        jenisMobilCol.setCellValueFactory(new PropertyValueFactory<>("jenisMobil")); // set the cell value factory for the jenisMobilCol column
        brandCol.setCellValueFactory(new PropertyValueFactory<>("merk")); // set the cell value factory for the brandCol column
        transmisiCol.setCellValueFactory(new PropertyValueFactory<>("transmisi")); // set the cell value factory for the transmisiCol column
        namaMobilCol.setCellValueFactory(new PropertyValueFactory<>("namaMobil")); // set the cell value factory for the namaMobilCol column
        kapasitasCol.setCellValueFactory(new PropertyValueFactory<>("kapasitas")); // set the cell value factory for the kapasitasCol column
        hargaCol.setCellValueFactory(new PropertyValueFactory<>("harga")); // set the cell value factory for the hargaCol column
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status")); // set the cell value factory for the statusCol column
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action")); // set the cell value factory for the actionCol column
        
        for (InformasiMobil informasiMobil : dataMobils) {
            informasiMobil.getAction().setId(Integer.toString(informasiMobil.getId())) ;
            informasiMobil.getAction().setOnAction(e-> {
                try{
                updateInfo(e);} catch(IOException ex){}
                });
        }
        tableView.setItems(dataMobils);
    }

    public void updateInfo(ActionEvent event)throws IOException {
        Button btn = (Button) event.getSource();
        ObservableList<InformasiMobil> dataMobils = FXCollections.observableArrayList(StorageInformasiMobil.getListMobil());
        InformasiMobil tempe = null;
        for (InformasiMobil informasiMobil : dataMobils) {
            if(informasiMobil.getId() == Integer.parseInt(btn.getId())){
                tempe = informasiMobil;
            }
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("informasiMobilEdit.fxml"));
        root = loader.load();

        InformasiMobilEditController update = loader.getController();
        update.showOldData(tempe);

        scene = new Scene(root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }

}
