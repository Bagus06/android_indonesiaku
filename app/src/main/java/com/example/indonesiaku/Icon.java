package com.example.indonesiaku;

import android.os.Parcel;
import android.os.Parcelable;

public class Icon implements Parcelable {
    private String nama, deskripsi, asal, foto, update, location;

    protected Icon(Parcel in) {
        nama = in.readString();
        deskripsi = in.readString();
        asal = in.readString();
        foto = in.readString();
        update = in.readString();
        location = in.readString();
    }

    public static final Parcelable.Creator<Icon> CREATOR = new Parcelable.Creator<Icon>() {
        @Override
        public Icon createFromParcel(Parcel in) {
            return new Icon(in);
        }

        @Override
        public Icon[] newArray(int size) {
            return new Icon[size];
        }
    };

    public Icon() {

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

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.deskripsi);
        parcel.writeString(this.asal);
        parcel.writeString(this.foto);
        parcel.writeString(this.update);
        parcel.writeString(this.location);
    }
}
