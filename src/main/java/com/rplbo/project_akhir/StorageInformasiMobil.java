package com.rplbo.project_akhir;

import java.util.ArrayList;

public class StorageInformasiMobil {
    
    public static ArrayList<InformasiMobil> listMobil = new ArrayList<InformasiMobil>();

    public static ArrayList<InformasiMobil> getListMobil(){
        return listMobil;
    }

    public static void addListMobil(InformasiMobil infoMobil){
        listMobil.add(infoMobil);
    }
}
