package com.example.indonesiaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailIconActivity extends AppCompatActivity {

    ImageView fotoView;
    TextView nama, deskripsi, asal, update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_icon);


        final Icon forMpas = getIntent().getParcelableExtra("kunci");
        TextView openMaps = (TextView) findViewById(R.id.openMaps);
        openMaps.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Uri gmmIntentUri = Uri.parse(forMpas.getLocation());
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                }, 100);
            }
        });

        Icon diterima = getIntent().getParcelableExtra("kunci");

        fotoView = (ImageView) findViewById(R.id.fotoView);
        nama = (TextView) findViewById(R.id.txt_nama);
        deskripsi = (TextView) findViewById(R.id.txt_deskripsi);
        asal = (TextView) findViewById(R.id.txt_asal);
        update = (TextView) findViewById(R.id.txt_update);

        Glide.with(this).load(diterima.getFoto()).into(fotoView);

        nama.setText(diterima.getNama());
        deskripsi.setText(diterima.getDeskripsi());
        asal.setText(diterima.getAsal());
        update.setText(diterima.getUpdate());
    }
}
