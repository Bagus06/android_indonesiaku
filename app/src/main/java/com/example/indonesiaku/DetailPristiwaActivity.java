package com.example.indonesiaku;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPristiwaActivity extends AppCompatActivity {

    ImageView fotoView;
    TextView nama, deskripsi, tanggal, update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pristiwa);

        Pristiwa diterima = getIntent().getParcelableExtra("kunci");

        fotoView = (ImageView) findViewById(R.id.fotoView);
        nama = (TextView) findViewById(R.id.txt_nama);
        deskripsi = (TextView) findViewById(R.id.txt_deskripsi);
        tanggal = (TextView) findViewById(R.id.txt_tanggal);
        update = (TextView) findViewById(R.id.txt_update);

        Glide.with(this).load(diterima.getFoto()).into(fotoView);

        nama.setText(diterima.getNama());
        deskripsi.setText(diterima.getDeskripsi());
        tanggal.setText(diterima.getTanggal());
        update.setText(diterima.getUpdate());


    }
}
