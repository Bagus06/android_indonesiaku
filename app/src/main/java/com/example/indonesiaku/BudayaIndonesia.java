package com.example.indonesiaku;

import java.util.ArrayList;

public class BudayaIndonesia {
    public static String[][] data = new String[][]{
            {
                    "Karapan Sapi",
                    "Karapan sapi merupakan istilah untuk menyebut perlombaan pacuan sapi yang berasal dari Pulau Madura, Jawa Timur. Pada perlombaan ini, sepasang sapi yang menarik semacam kereta dari kayu dipacu dalam lomba adu cepat melawan pasangan-pasangan sapi lain.\r\n\r\nUmumnya dilaksanakan pada : Agustus hingga Oktober",
                    "Jawa Timur, Pulau Madura",
                    "https://nusantaranews.co/assets/uploads/2019/09/Pemkab-Sumenep-Akan-Gelar-Lomba-Karapan-Sapi-Tingkat-Kabupaten-di-Lapangan-Giling.jpg",
                    "15 Feb 2020"
            }
    };

    public static ArrayList<Budaya> getListDAta() {
        Budaya budaya = null;
        ArrayList<Budaya> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            budaya = new Budaya();
            budaya.setName(data[i][0]);
            budaya.setDeskripsi(data[i][1]);
            budaya.setAsal(data[i][2]);
            budaya.setFoto(data[i][3]);
            budaya.setUpdate(data[i][4]);

            list.add(budaya);

        }
        return list;

    }
}
