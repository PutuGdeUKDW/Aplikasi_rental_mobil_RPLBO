package com.rplbo.project_akhir;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StatusPembayaran {
    @FXML
    Button menuUtamaButton;

    Parent root;
    Scene scene;
    Stage stage;

    public void toForward(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMainMenu.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();}}
