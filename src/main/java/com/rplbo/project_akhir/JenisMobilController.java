package com.rplbo.project_akhir;

import java.net.URL;
import java.util.ResourceBundle;

//import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
        new JenisMobilTable(1, "tes", "null", "null", 2, "null", "null"),
        new JenisMobilTable(2, "tes2", "null2", "null2", 1, "null2", "null2"),
        new JenisMobilTable(3, "tes3", "null3", "null3", 2, "null3", "null3")
    );


    public void initialize(URL url,ResourceBundle rb){
        
        namaMobil.setCellValueFactory(new PropertyValueFactory<>("namaMobil"));
        merk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        mesin.setCellValueFactory(new PropertyValueFactory<>("mesin"));
        kapasitas.setCellValueFactory(new PropertyValueFactory<>("kapasitas"));
        transmisi.setCellValueFactory(new PropertyValueFactory<>("transmisi"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
    
        jenisMobilTable.setItems(list);
    }
    
    
    public void toLogin() {
        // Implement the logic for navigating back to the login screen
    }
    
    public void addJenisMobil() {
        // Implement the logic for adding a new jenis mobil
    }
    
    public void search() {
        // Implement the logic for searching jenis mobil
    }
    
    // Implement other methods for updating the jenisMobilTable
}
