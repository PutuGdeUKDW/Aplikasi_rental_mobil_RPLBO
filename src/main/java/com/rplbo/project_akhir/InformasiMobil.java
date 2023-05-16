package com.rplbo.project_akhir;

import javafx.scene.control.Button;

public class InformasiMobil {
    JenisMobilTable jenisMobil;
    String namaMobil;
    double harga;
    boolean status = true;
    Button action = new Button("Edit");
    int id;
    static int nextId=0;

    public InformasiMobil(JenisMobilTable jenisMobil,String namaMobil,double harga){
        this.id = nextId;
        this.jenisMobil = jenisMobil;
        this.namaMobil = namaMobil;
        this.harga = harga;
        this.action.setText("Edit");
        nextId++;
    }

    public int getId() {
        return id;
    }
    public Button getAction(){
        return this.action;
    }
    public String getJenisMobil() {
        return jenisMobil.getNamaMobil();
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    public int getKapasitas() {
        return jenisMobil.getKapasitas();
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public String getMerk() {
        return jenisMobil.getMerk();
    }

    public String getMesin() {
        return jenisMobil.getMesin();
    }

    public String getTransmisi() {
        return jenisMobil.getTransmisi();
    }

    public String getJenis() {
        return jenisMobil.getJenis();
    }
    
    public void setKapasitas(int kapasitas) {
        jenisMobil.setKapasitas(kapasitas);
    }
    
    public void setNamaMobil(String namaMobil) {
        jenisMobil.setNamaMobil(namaMobil);
    }
    
    public void setMerk(String merk) {
        jenisMobil.setMerk(merk);
    }
    
    public void setMesin(String mesin) {
        jenisMobil.setMerk(mesin);;
    }
    
    public void setTransmisi(String transmisi) {
        jenisMobil.setTransmisi(transmisi);
    }
    
    public void setJenis(String jenis) {
        jenisMobil.setJenis(jenis);
    }
}
