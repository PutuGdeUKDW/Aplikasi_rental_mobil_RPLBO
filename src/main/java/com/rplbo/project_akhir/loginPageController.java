package com.rplbo.project_akhir;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class loginPageController {
    @FXML
    Button loginButton;
    @FXML
    Button backButton;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label note;

    Parent root;
    Scene scene;

    Stage stage;

    public void toAdminHome(ActionEvent event)throws IOException {
        if ((this.username.getText().equals("stefanus")) && (this.password.getText().equals("123"))){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHome.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();} else {
            note.setVisible(true);
            note.setText("Username atau password salah!");
            note.setTextFill(Color.web("#FF0000"));
        }
    }

    
    public void toBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginUser.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
}
