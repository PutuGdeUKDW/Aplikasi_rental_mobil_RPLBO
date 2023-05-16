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
        new JenisMobilTable(1, "tes", "null", "null", 2, "Matic", "null"),
        new JenisMobilTable(2, "tes2", "null2", "null2", 1, "Manual", "null2"),
        new JenisMobilTable(3, "tes3", "null3", "null3", 2, "Matic", "null3")
    );

    Parent root;
    Scene scene;

    Stage stage;


    public void initialize(URL url,ResourceBundle rb){
        
        namaMobil.setCellValueFactory(new PropertyValueFactory<>("namaMobil"));
        merk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        mesin.setCellValueFactory(new PropertyValueFactory<>("mesin"));
        kapasitas.setCellValueFactory(new PropertyValueFactory<>("kapasitas"));
        transmisi.setCellValueFactory(new PropertyValueFactory<>("transmisi"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
    
        jenisMobilTable.setItems(list);

        
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
    
    public void addJenisMobil() {
        // Implement the logic for adding a new jenis mobil
    }
    
    public void search() {
        // Implement the logic for searching jenis mobil
    }
    
    // Implement other methods for updating the jenisMobilTable
}
