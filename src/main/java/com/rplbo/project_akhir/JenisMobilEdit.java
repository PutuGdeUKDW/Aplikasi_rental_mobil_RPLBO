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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JenisMobilEdit implements Initializable{
    @FXML
    private Pane rootPane;

    @FXML
    private Button backButton;

    @FXML
    private TextField namaJenisMobilTextField;

    @FXML
    private TextField merkTextField;

    @FXML
    private Label namaJenisMobilLabel;

    @FXML
    private Label merkLabel;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField mesinTextField;

    @FXML
    private Label mesinLabel;

    @FXML
    private TextField kapasitasTextField;

    @FXML
    private Label kapasitasLabel;

    @FXML
    private RadioButton manualRadioButton;

    @FXML
    private RadioButton maticRadioButton;

    @FXML
    private Label transmisiLabel;

    @FXML
    private Label jenisLabel;

    @FXML
    private ComboBox<String> jenisComboBox;

    Parent root;
    Scene scene;

    Stage stage;

    JenisMobilTable oldinfo;
    public void showOldData(JenisMobilTable old){
        oldinfo = old;
        String nama = old.getNamaMobil();
        String merk = old.getMerk();
        String mesin = old.getMesin();
        int kapasitas = old.getKapasitas();
        String transmisi = old.getTransmisi();
        String jenis = old.getJenis();
        namaJenisMobilTextField.setText(nama);
        merkTextField.setText(merk);
        mesinTextField.setText(mesin);
        kapasitasTextField.setText(Integer.toString(kapasitas));
        if(transmisi.equals("Manual")){
            manualRadioButton.setSelected(true);
        } else if(transmisi.equals("Matic")){
            manualRadioButton.setSelected(true);}
        jenisComboBox.setValue(jenis);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> carTypes = FXCollections.observableArrayList("SUV", "Crossover", "Sedan", "LCGC", "Sport");
        jenisComboBox.setItems(carTypes);
    }

    public void saveButtonAction(ActionEvent event) {
        String namaPlatMobil = namaJenisMobilTextField.getText();
        String merk = merkTextField.getText();
        String mesin = mesinTextField.getText();
        String transmisi = "";
        if(manualRadioButton.isSelected()){
            transmisi = "Manual";
        }else if(maticRadioButton.isSelected()){
            transmisi = "Matic";
        }

        int kapasitas = Integer.parseInt(kapasitasTextField.getText());
        
        String jenis = jenisComboBox.getValue();
        JenisMobilTable mobil = new JenisMobilTable(namaPlatMobil, merk, mesin, kapasitas, transmisi, jenis);

        for (JenisMobilTable mag : StorageJenisMobil.getListJenis()) {
            if(mag.getId() == oldinfo.getId()){
                int index = StorageJenisMobil.getListJenis().indexOf(mag);
                StorageJenisMobil.getListJenis().set(index, mobil);
                break;
            }}

    }

    public void toBack(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("jenisMobil.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }

    public void deleteButtonAction(ActionEvent event){
        for (JenisMobilTable mag : StorageJenisMobil.getListJenis()) {
            if(mag.getId() == oldinfo.getId()){
                StorageJenisMobil.getListJenis().remove(mag);
            }}
    }
}
