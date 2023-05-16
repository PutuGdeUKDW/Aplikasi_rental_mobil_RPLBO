package com.rplbo.project_akhir;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MetodePembayaran {
    
    @FXML
    private Button kembaliButton;

    @FXML
    private TextField namaPeminjamTextField;

    @FXML
    private TextField nomorTeleponTextField;

    @FXML
    private ImageView mobilImageView;

    @FXML
    private DatePicker awalPeminjamanDatePicker;

    @FXML
    private DatePicker akhirPeminjamanDatePicker;

    @FXML
    private TextArea deskripsiRentalTextArea;

    @FXML
    private Button metodePembayaranButton;

    Parent root;
    Scene scene;
    Stage stage;

    public void toBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPembayaran.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    

    public void toForward(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StatusPembayaran.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
}
