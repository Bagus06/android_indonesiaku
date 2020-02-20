package com.example.indonesiaku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListBudayaAdapter extends RecyclerView.Adapter<ListBudayaAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Budaya> listBudaya;
    private ListBudayaAdapter.OnClick onClick;

    public ListBudayaAdapter(Context context, ListBudayaAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListBudayaAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_budaya, viewGroup, false);
        ListBudayaAdapter.CardViewViewHolder viewHolder = new ListBudayaAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListBudayaAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Budaya p = getListBudaya().get(i);
        cardViewViewHolder.tampil(p, onClick);
//
//        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
//
//            @Override
//            public void onItemClicked(View v, int position) {
//                Toast.makeText(context, "Share info tentang " + getListMeuble().get(position).getNama(), Toast.LENGTH_SHORT).show();
//            }
//        }));

    }

    @Override
    public int getItemCount() {
        return getListBudaya().size();
    }

    public ArrayList<Budaya> getListBudaya() {
        return listBudaya;
    }

    public void setListBudaya(ArrayList<Budaya> listBudaya) {
        this.listBudaya= listBudaya;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoView;
        TextView tvNama;
        CardView btnDetail;
        Budaya budaya;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            fotoView = (ImageView) itemView.findViewById(R.id.fotoView);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.itm_card);

        }

        public void tampil(final Budaya budaya, final ListBudayaAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(budaya.getFoto())
                    .into(fotoView);

            tvNama.setText(budaya.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(budaya);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object budaya);
    }
}
