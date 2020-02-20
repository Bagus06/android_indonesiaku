package com.example.indonesiaku;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IconActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Icon> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);
//        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(IconIndonesia.getListDAta());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListIconAdapter listIconAdapter= new ListIconAdapter(this, new ListIconAdapter.OnClick() {
            @Override
            public void onClick(Object icon) {
                Icon icon1 = (Icon) icon;
                Intent intent = new Intent(IconActivity.this, DetailIconActivity.class);
                intent.putExtra("kunci", icon1);
                startActivity(intent);
            }
        });
        listIconAdapter.setListIcon(list);
        recyclerView.setAdapter(listIconAdapter);
    }
}
