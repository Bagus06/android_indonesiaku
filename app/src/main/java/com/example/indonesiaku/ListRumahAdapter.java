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

public class ListRumahAdapter extends RecyclerView.Adapter<ListRumahAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Rumah> listRumah;
    private ListRumahAdapter.OnClick onClick;

    public ListRumahAdapter(Context context, ListRumahAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListRumahAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rumah, viewGroup, false);
        ListRumahAdapter.CardViewViewHolder viewHolder = new ListRumahAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListRumahAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Rumah p = getListRumah().get(i);
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
        return getListRumah().size();
    }

    public ArrayList<Rumah> getListRumah() {
        return listRumah;
    }

    public void setListRumah(ArrayList<Rumah> listRumah) {
        this.listRumah = listRumah;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoView;
        TextView tvNama;
        CardView btnDetail;
        Rumah rumah;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            fotoView = (ImageView) itemView.findViewById(R.id.fotoView);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.itm_card);

        }

        public void tampil(final Rumah rumah, final ListRumahAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(rumah.getFoto())
                    .into(fotoView);

            tvNama.setText(rumah.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(rumah);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object rumah);
    }
}