package com.example.indonesiaku;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMakananActivity extends AppCompatActivity {

    ImageView fotoView;
    TextView nama, deskripsi, tutorial, asal, update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        Makanan diterima = getIntent().getParcelableExtra("kunci");

        fotoView = (ImageView) findViewById(R.id.fotoView);
        nama = (TextView) findViewById(R.id.txt_nama);
        deskripsi = (TextView) findViewById(R.id.txt_deskripsi);
        tutorial = (TextView) findViewById(R.id.txt_tutorial);
        asal = (TextView) findViewById(R.id.txt_asal);
        update = (TextView) findViewById(R.id.txt_update);

        Glide.with(this).load(diterima.getFoto()).into(fotoView);

        nama.setText(diterima.getNama());
        deskripsi.setText(diterima.getDeskripsi());
        tutorial.setText(diterima.getTutorial());
        asal.setText(diterima.getAsal());
        update.setText(diterima.getUpdate());


    }
}
