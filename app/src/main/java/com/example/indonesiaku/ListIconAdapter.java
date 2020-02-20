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

public class ListIconAdapter extends RecyclerView.Adapter<ListIconAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Icon> listIcon;
    private ListIconAdapter.OnClick onClick;

    public ListIconAdapter(Context context, ListIconAdapter.OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public ListIconAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_icon, viewGroup, false);
        ListIconAdapter.CardViewViewHolder viewHolder = new ListIconAdapter.CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListIconAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        Icon p = getListIcon().get(i);
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
        return getListIcon().size();
    }

    public ArrayList<Icon> getListIcon() {
        return listIcon;
    }

    public void setListIcon(ArrayList<Icon> listIcon) {
        this.listIcon = listIcon;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoView;
        TextView tvNama;
        CardView btnDetail;
        Icon icon;


        public CardViewViewHolder(View itemView) {
            super(itemView);
            fotoView = (ImageView) itemView.findViewById(R.id.fotoView);
            tvNama = (TextView) itemView.findViewById(R.id.txt_nama);
            btnDetail = (CardView) itemView.findViewById(R.id.itm_card);

        }

        public void tampil(final Icon icon, final ListIconAdapter.OnClick OnItemClick) {

            Glide.with(context)
                    .load(icon.getFoto())
                    .into(fotoView);

            tvNama.setText(icon.getNama());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(icon);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object icon);
    }
}
