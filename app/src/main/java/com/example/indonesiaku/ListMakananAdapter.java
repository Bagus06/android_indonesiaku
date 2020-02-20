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

public class ListMakananAdapter extends RecyclerView.Adapter<ListMakananAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Makanan> listMakanan;
    private ListMakananAdapter.OnClick onClick;

    public ListMakananAdapter(Context context, ListMakananAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListMakananAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_makanan, viewGroup, false);
        ListMakananAdapter.CardViewViewHolder viewHolder = new ListMakananAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListMakananAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Makanan p = getListMakanan().get(i);
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
        return getListMakanan().size();
    }

    public ArrayList<Makanan> getListMakanan() {
        return listMakanan;
    }

    public void setListMakanan(ArrayList<Makanan> listMakanan) {
        this.listMakanan= listMakanan;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoView;
        TextView tvNama;
        CardView btnDetail;
        Makanan makanan;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            fotoView = (ImageView) itemView.findViewById(R.id.fotoView);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.itm_card);

        }

        public void tampil(final Makanan makanan, final ListMakananAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(makanan.getFoto())
                    .into(fotoView);

            tvNama.setText(makanan.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(makanan);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object makanan);
    }
}
