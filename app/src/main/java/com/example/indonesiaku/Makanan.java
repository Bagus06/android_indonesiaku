package com.example.indonesiaku;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan implements Parcelable {
    private String nama, deskripsi, tutorial, asal, foto, update;

    protected Makanan(Parcel in) {
        nama = in.readString();
        deskripsi = in.readString();
        tutorial = in.readString();
        asal = in.readString();
        foto = in.readString();
        update = in.readString();
    }

    public static final Parcelable.Creator<Makanan> CREATOR = new Parcelable.Creator<Makanan>() {
        @Override
        public Makanan createFromParcel(Parcel in) {
            return new Makanan(in);
        }

        @Override
        public Makanan[] newArray(int size) {
            return new Makanan[size];
        }
    };

    public Makanan() {

    }


    public String getNama() {

        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {

        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTutorial() {

        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    public String getAsal() {

        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getFoto() {

        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUpdate() {

        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.deskripsi);
        parcel.writeString(this.tutorial);
        parcel.writeString(this.asal);
        parcel.writeString(this.foto);
        parcel.writeString(this.update);
    }
}
