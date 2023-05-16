package com.rplbo.project_akhir;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InformasiMobilEditController implements Initializable {
    @FXML
    private Pane rootPane;

    @FXML
    private Button backButton;

    @FXML
    private TextField namaPlatMobilField;

    @FXML
    private TextField hargaRentalField;

    @FXML
    private Label jenisMobilLabel;

    @FXML
    private ComboBox<String> jenisMobilComboBox;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button uploadImageButton;

    @FXML
    private ImageView imageView;

    Parent root;
    Scene scene;
    Stage stage;

    InformasiMobil mobil; 

    JenisMobilController jenisMobilTableList = new JenisMobilController();
    ObservableList<String> jenisMobilList = FXCollections.observableArrayList();

    InformasiMobil oldInfo;

    public void showOldData(InformasiMobil old){
        oldInfo = old;
        String nama = old.getNamaMobil();
        String jenis = old.getJenisMobil();
        double harga = old.getHarga();

        namaPlatMobilField.setText(nama);
        hargaRentalField.setText(String.valueOf(harga));
        jenisMobilComboBox.setValue(jenis);
        
    }


    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHome.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (JenisMobilTable jenisMobil : StorageJenisMobil.getListJenis()) {
            jenisMobilList.add(jenisMobil.getNamaMobil());
        }
        jenisMobilComboBox.setItems(jenisMobilList);
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        String namaPlatMobil = namaPlatMobilField.getText();
        String hargaRental = hargaRentalField.getText();
        String jenisMobil = jenisMobilComboBox.getValue();
        JenisMobilTable jenisMobilObj = null;
        System.out.println("Size of jenisMobilTableList: " + StorageJenisMobil.getListJenis());
        for (JenisMobilTable j : StorageJenisMobil.getListJenis()) {
            System.out.println(j.getNamaMobil());
            if (j.getNamaMobil().equals(jenisMobil)) {
                System.out.println("Success");
                jenisMobilObj = j;
                break;
            }}
            this.mobil = new InformasiMobil(jenisMobilObj, namaPlatMobil, Double.parseDouble(hargaRental));

            AdminHomeController jenisMobilController = new AdminHomeController();
            
            for (InformasiMobil mag : StorageInformasiMobil.getListMobil()) {
                if(mag.getId() == oldInfo.getId()){
                    int index = StorageInformasiMobil.getListMobil().indexOf(mag);
                    StorageInformasiMobil.getListMobil().set(index, mobil);
                }
                
            }
            for (InformasiMobil i : jenisMobilController.getData()) {
                System.out.println(i.getNamaMobil() + " , " + i.getJenisMobil());
            }
            //jenisMobilController.refreshData();
        }

    public InformasiMobil getMobil(){
        return mobil;
    }

    public void setMobil(InformasiMobil mobil){
        this.mobil = mobil;
    }

    public void deleteButtonAction(ActionEvent event){

        for (InformasiMobil mag : StorageInformasiMobil.getListMobil()) {
            if(mag.getId() == oldInfo.getId()){
                StorageInformasiMobil.getListMobil().remove(mag);
            }
            
        
    }}
}
