package com.rplbo.project_akhir;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        JenisMobilTable jenisOBJ = new JenisMobilTable("tes", "null", "null", 2, "Matic", "null");
        JenisMobilTable jenisOBJ2 =new JenisMobilTable("tes2", "null2", "null2", 1, "Manual", "null2");
        JenisMobilTable jenisOBJ3 =new JenisMobilTable("tes3", "null3", "null3", 2, "Matic", "null3");
        StorageJenisMobil.getListJenis().add(jenisOBJ);
        StorageJenisMobil.getListJenis().add(jenisOBJ2);
        StorageJenisMobil.getListJenis().add(jenisOBJ3);
        InformasiMobil mobilOBJ = new InformasiMobil(StorageJenisMobil.getListJenis().get(0),"DD 1 AA",10000);
        InformasiMobil mobilOBJ1 = new InformasiMobil(StorageJenisMobil.getListJenis().get(1),"DD 2 AA",15000);

        StorageInformasiMobil.getListMobil().add(mobilOBJ);
        StorageInformasiMobil.getListMobil().add(mobilOBJ1);


        FXMLLoader root = new FXMLLoader(getClass().getResource("LoginUser.fxml"));
        Scene scene = new Scene(root.load());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rental Mobil");
        primaryStage.show();


    }
}
