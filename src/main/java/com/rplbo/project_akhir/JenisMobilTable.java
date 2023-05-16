package com.rplbo.project_akhir;

import javafx.scene.control.Button;

public class JenisMobilTable {
    int id,kapasitas;
    String namaMobil,merk,mesin,transmisi,jenis;
    static int nextId=0;
    Button action = new Button("Edit");

    public JenisMobilTable(String namaMobil,String merk,String mesin ,int kapasitas,String transmisi,String jenis){
        this.namaMobil = namaMobil;
        this.merk = merk;
        this.mesin = mesin;
        this.kapasitas = kapasitas;
        this.transmisi = transmisi;
        this.jenis = jenis;
        this.id = nextId;
        this.action.setText("Edit");
        nextId++;
    }
    public int getId() {
        return id;
    }

    public Button getAction(){
        return this.action;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public String getMerk() {
        return merk;
    }

    public String getMesin() {
        return mesin;
    }

    public String getTransmisi() {
        return transmisi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }
    
    public void setMerk(String merk) {
        this.merk = merk;
    }
    
    public void setMesin(String mesin) {
        this.mesin = mesin;
    }
    
    public void setTransmisi(String transmisi) {
        this.transmisi = transmisi;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    

}
