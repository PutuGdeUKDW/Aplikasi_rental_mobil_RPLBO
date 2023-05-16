package com.rplbo.project_akhir;

import java.util.ArrayList;


public class StorageJenisMobil {
    public static ArrayList<JenisMobilTable> listJenis = new ArrayList<JenisMobilTable>();

    public static ArrayList<JenisMobilTable> getListJenis(){
        return listJenis;
    }

    public static void addListJenis(JenisMobilTable infoMobil){
        listJenis.add(infoMobil);
    }
}
