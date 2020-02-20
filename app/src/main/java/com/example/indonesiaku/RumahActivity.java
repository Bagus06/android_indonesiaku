package com.example.indonesiaku;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RumahActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Rumah> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah);
//        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(RumahIndonesia.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListRumahAdapter listRumahAdapter= new ListRumahAdapter(this, new ListRumahAdapter.OnClick() {
            @Override
            public void onClick(Object rumah) {
                Rumah rumah1 = (Rumah) rumah;
                Intent intent = new Intent(RumahActivity.this, DetailRumahActivity.class);
                intent.putExtra("kunci", rumah1);
                startActivity(intent);
            }
        });
        listRumahAdapter.setListRumah(list);
        recyclerView.setAdapter(listRumahAdapter);
    }
}
