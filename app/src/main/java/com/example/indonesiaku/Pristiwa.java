package com.example.indonesiaku;

import android.os.Parcel;
import android.os.Parcelable;

public class Pristiwa implements Parcelable {
    private String nama, deskripsi, tanggal, foto, update;

    protected Pristiwa(Parcel in) {
        nama = in.readString();
        deskripsi = in.readString();
        tanggal = in.readString();
        foto = in.readString();
        update = in.readString();
    }

    public static final Parcelable.Creator<Pristiwa> CREATOR = new Parcelable.Creator<Pristiwa>() {
        @Override
        public Pristiwa createFromParcel(Parcel in) {
            return new Pristiwa(in);
        }

        @Override
        public Pristiwa[] newArray(int size) {
            return new Pristiwa[size];
        }
    };

    public Pristiwa() {

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

    public String getTanggal() {

        return tanggal;
    }

    public void setTanggal(String tangal) {
        this.tanggal = tangal;
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
        parcel.writeString(this.tanggal);
        parcel.writeString(this.foto);
        parcel.writeString(this.update);
    }
}
