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

public class ListPristiwaAdapter extends RecyclerView.Adapter<ListPristiwaAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Pristiwa> listPristiwa;
    private ListPristiwaAdapter.OnClick onClick;

    public ListPristiwaAdapter(Context context, ListPristiwaAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListPristiwaAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pristiwa, viewGroup, false);
        ListPristiwaAdapter.CardViewViewHolder viewHolder = new ListPristiwaAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListPristiwaAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Pristiwa p = getListPristiwa().get(i);
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
        return getListPristiwa().size();
    }

    public ArrayList<Pristiwa> getListPristiwa() {
        return listPristiwa;
    }

    public void setListPristiwa(ArrayList<Pristiwa> listPristiwa) {
        this.listPristiwa = listPristiwa;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoView;
        TextView tvNama;
        CardView btnDetail;
        Pristiwa pristiwa;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            fotoView = (ImageView) itemView.findViewById(R.id.fotoView);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.itm_card);

        }

        public void tampil(final Pristiwa pristiwa, final ListPristiwaAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(pristiwa.getFoto())
                    .into(fotoView);

            tvNama.setText(pristiwa.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(pristiwa);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object pristiwa);
    }
}
