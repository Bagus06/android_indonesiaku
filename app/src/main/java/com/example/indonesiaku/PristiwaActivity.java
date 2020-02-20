package com.example.indonesiaku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;

public class PristiwaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Pristiwa> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pristiwa);
//        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(PristiwaIndonesia.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListPristiwaAdapter listPristiwaAdapter= new ListPristiwaAdapter(this, new ListPristiwaAdapter.OnClick() {
            @Override
            public void onClick(Object pristiwa) {
                Pristiwa pristiwa1 = (Pristiwa) pristiwa;
                Intent intent = new Intent(PristiwaActivity.this, DetailPristiwaActivity.class);
                intent.putExtra("kunci", pristiwa1);
                startActivity(intent);
            }
        });
        listPristiwaAdapter.setListPristiwa(list);
        recyclerView.setAdapter(listPristiwaAdapter);
    }
}
