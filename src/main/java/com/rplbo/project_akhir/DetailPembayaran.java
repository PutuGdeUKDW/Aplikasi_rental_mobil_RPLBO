package com.rplbo.project_akhir;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

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

public class DetailPembayaran {

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
    
    InformasiMobil mobil;
    Parent root;
    Scene scene;
    Stage stage;
    public void showOldData(InformasiMobil mobil) {
        String rentalDescription = "Deskripsi Total Rental :\n\n" +
        "Biaya Rental = Rp. "+mobil.getHarga()+"\n\n" +
        "Total Hari Peminjaman = 0 hari\n" +
        "----------------------------------------\n" +
        "Total Tagihan = Rp. 0";

        this.mobil = mobil;
        //carTitle.setText(mobil.getJenisMobil());
        //rentalPrice.setText("Rp. " + mobil.getHarga() + "/Hari");
        deskripsiRentalTextArea.setText(rentalDescription);
        //carImage.setImage(mobil.getGambar());
        awalPeminjamanDatePicker.setOnAction(event -> updateRentalDescription());
        akhirPeminjamanDatePicker.setOnAction(event -> updateRentalDescription());
    }
    private void updateRentalDescription() {
        LocalDate startDate = awalPeminjamanDatePicker.getValue();
        LocalDate endDate = akhirPeminjamanDatePicker.getValue();

        if (startDate != null && endDate != null) {
            Duration duration = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay());
            long days = duration.toDays();
            if(days<1){
                days=1;
            }

            String rentalDescription = "Deskripsi Total Rental :\n\n" +
                    "Biaya Rental = Rp. " + mobil.getHarga() + "\n\n" +
                    "Total Hari Peminjaman = " + days+1 + " hari\n" +
                    "----------------------------------------\n" +
                    "Total Tagihan = Rp. " + ((days+1) * mobil.getHarga());

            deskripsiRentalTextArea.setText(rentalDescription);
        }
    }

    public void toBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailMobil.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
    

    public void toForward(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MetodePembayaran.fxml"));
        this.root = loader.load();
        this.scene = new Scene(this.root);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.stage.setScene(scene);
        this.stage.show();
    }
}
