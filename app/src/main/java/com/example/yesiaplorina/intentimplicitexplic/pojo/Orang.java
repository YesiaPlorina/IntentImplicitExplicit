package com.example.yesiaplorina.intentimplicitexplic.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Orang implements Parcelable {

    //TODO 3.1 deklarasikan variabelnya

    private String name, asal, tinggal, pekerjaan;
    private int age;

    //TODO 3.2 generate method getter dan setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTinggal() {
        return tinggal;
    }

    public void setTinggal(String tinggal) {
        this.tinggal = tinggal;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.asal);
        dest.writeString(this.tinggal);
        dest.writeString(this.pekerjaan);
        dest.writeInt(this.age);
    }

    public Orang() {
    }

    protected Orang(Parcel in) {
        this.name = in.readString();
        this.asal = in.readString();
        this.tinggal = in.readString();
        this.pekerjaan = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Orang> CREATOR = new Parcelable.Creator<Orang>() {
        @Override
        public Orang createFromParcel(Parcel source) {
            return new Orang(source);
        }

        @Override
        public Orang[] newArray(int size) {
            return new Orang[size];
        }
    };
}
