package com.example.indonesiaku;

import java.util.ArrayList;

public class MakananIndonesia {
    public static String[][] data = new String[][]{
            {
                    "Mie Aceh",
                    "Aceh merupakan salah satu provinsi di Indonesia yang terkenal dengan berbagai kuliner khas terbaik yang bahkan telah mendunia. Saat berkunjung ke Aceh, belum lengkap rasanya jika Anda tidak bisa mencicipi menu dengan bahan mie kuning tebal plus irisan daging yang disajikan dalam sup kari gurih dan pedas yang satu ini.",
                    "Bahan-bahan\r\n250 gr mie kering (saya pakai mie lidi). Rebus matang. Tiriskan\r\n6 bh bawang merah\r\n4 bh bawang putih\r\n7 bh cabe merah/sesuai selera\r\n10 bh cabe rawit/sesuai selera\r\n1 bh tomat\r\n1 ruas jahe\r\n4 btr kemiri sangrai\r\n2 btr telur kocok\r\n1 sdm bubuk kari\r\n3 sdm kecap manis\r\n2 sdm kecap asin\r\n1 cangkir air (kaldu lbh enak)\r\nSecukupnya garam gula\r\nSecukupnya kol, sawi, seledri iris\r\nSecukupnya penyedap bubuk\r\nSecukupnya minyak goring\r\n\r\nPelengkap:\r\nAcar\r\nTomat timun jeruk nipis\r\nBawang merah goreng\r\nKerupuk\r\n\r\nLangkah\r\n1.\tHaluskan bahan2 sbb: cabe2an, duo bawang, jahe, kemiri dan tomat.\r\n\r\n2.\tPanaskan minyak, tumis bumbu halus sampai wangi. Masukkan telur. Aduk2 sampai rata dan telur kaku. Kalau ada tambahan lain spt ayam, irisan daging, udang atau lainnya silakan dimasukkan dalam tahapan ini.\r\n\r\n3.\tMasukkan sayur2an dan air kaldu. Tambahkan sisa bahan lainnya.\r\n\r\n4.\tMasukkan mie. Aduk rata. Check rasa sesuai selera. Angkat.\r\n\r\n5.\tSajikan mie aceh segera dengan pelengkapnya. Yummy... ",
                    "Jawa Timur, Pulau Madura",
                    "https://www.gotravelly.com/blog/wp-content/uploads/2018/03/makanan-khas-daerah-mie-aceh.jpg",
                    "15 Feb 2020"
            }

    };

    public static ArrayList<Makanan> getListDAta() {
        Makanan makanan = null;
        ArrayList<Makanan> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            makanan = new Makanan();
            makanan.setName(data[i][0]);
            makanan.setDeskripsi(data[i][1]);
            makanan.setTutorial(data[i][2]);
            makanan.setAsal(data[i][3]);
            makanan.setFoto(data[i][4]);
            makanan.setUpdate(data[i][5]);

            list.add(makanan);

        }
        return list;

    }
}
