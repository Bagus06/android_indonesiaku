package com.example.indonesiaku;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MakananActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Makanan> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);
//        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(MakananIndonesia.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListMakananAdapter listMakananAdapter= new ListMakananAdapter(this, new ListMakananAdapter.OnClick() {
            @Override
            public void onClick(Object makanan) {
                Makanan makanan1 = (Makanan) makanan;
                Intent intent = new Intent(MakananActivity.this, DetailMakananActivity.class);
                intent.putExtra("kunci", makanan1);
                startActivity(intent);
            }
        });
        listMakananAdapter.setListMakanan(list);
        recyclerView.setAdapter(listMakananAdapter);
    }
}
