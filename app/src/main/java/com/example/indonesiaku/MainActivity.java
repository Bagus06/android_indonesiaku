package com.example.indonesiaku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView btnBudaya = (CardView) findViewById(R.id.btnBudaya);
        btnBudaya.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,BudayaActivity.class);
                startActivity(i);
            }
        });

        CardView btnRunmah = (CardView) findViewById(R.id.btnRmhAdat);
        btnRunmah.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,RumahActivity.class);
                startActivity(i);
            }
        });

        CardView btnMakanan = (CardView) findViewById(R.id.btnMakanan);
        btnMakanan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,MakananActivity.class);
                startActivity(i);
            }
        });

        CardView btnIcon = (CardView) findViewById(R.id.btnIcon);
        btnIcon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,IconActivity.class);
                startActivity(i);
            }
        });

        CardView btnPristiwa = (CardView) findViewById(R.id.btnPeristiwa);
        btnPristiwa.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,PristiwaActivity.class);
                startActivity(i);
            }
        });

    }
}
