package com.rplbo.project_akhir;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailMobil {

    @FXML
    private Button backButton;

    @FXML
    private Text carTitle;

    @FXML
    private Text rentalPrice;

    @FXML
    private Text detailLabel;

    @FXML
    private TextArea detailTextArea;

    @FXML
    private Button rentalButton;

    @FXML
    private ImageView carImage;

    Parent root;
    Scene scene;
    Stage stage;

    InformasiMobil mobil;
    public void showOldData(InformasiMobil mobil) {
        String details = "- Merek: " +mobil.getMerk()+"\n" +
        "- Transmisi: " +mobil.getTransmisi()+"\n" +
        "- Kapasitas Tempat Duduk: " +mobil.getKapasitas()+"\n" +
        "- Mesin:" +mobil.getMesin()+"\n" +
        "- Jenis: " +mobil.getJenis();
        this.mobil = mobil;
        carTitle.setText(mobil.getJenisMobil());
        rentalPrice.setText("Rp. " + mobil.getHarga() + "/Hari");
        detailTextArea.setText(details);
        //carImage.setImage(mobil.getGambar());
    }
    public void toBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMainMenu.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    public void toDetail(ActionEvent event) throws IOException {
        ObservableList<InformasiMobil> dataMobils = FXCollections.observableArrayList(StorageInformasiMobil.getListMobil());
        InformasiMobil tempe = null;
        for (InformasiMobil informasiMobil : dataMobils) {
            if(informasiMobil.getId() == mobil.getId()){
                tempe = informasiMobil;
            }
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPembayaran.fxml"));
        this.root = loader.load();

        DetailPembayaran update = loader.getController();
        update.showOldData(tempe);

        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }

    public void rental(ActionEvent event) throws IOException{
        ObservableList<InformasiMobil> dataJenis = FXCollections.observableArrayList(StorageInformasiMobil.getListMobil());
        for (InformasiMobil jenisMobil : dataJenis) {
            jenisMobil.getAction().setId(Integer.toString(jenisMobil.getId())) ;
            jenisMobil.getAction().setOnAction(e-> {
                try{
                toDetail(e);} catch(IOException ex){}
                });
        }   
    }
}
