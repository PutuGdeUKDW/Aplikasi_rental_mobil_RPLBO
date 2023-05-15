package com.rplbo.project_akhir;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(root.load());


        primaryStage.setScene(scene);
        primaryStage.setTitle("Rental Mobil");
        primaryStage.show();


    }
}
