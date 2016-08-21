package com.simpals.testtask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vadim on 21.08.2016.
 */
public class Translations implements Parcelable {

    @SerializedName("de")
    @Expose
    private String de;
    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("fr")
    @Expose
    private String fr;
    @SerializedName("ja")
    @Expose
    private String ja;
    @SerializedName("it")
    @Expose
    private String it;

    protected Translations(Parcel in) {
        de = in.readString();
        es = in.readString();
        fr = in.readString();
        ja = in.readString();
        it = in.readString();
    }

    public static final Creator<Translations> CREATOR = new Creator<Translations>() {
        @Override
        public Translations createFromParcel(Parcel in) {
            return new Translations(in);
        }

        @Override
        public Translations[] newArray(int size) {
            return new Translations[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(de);
        parcel.writeString(es);
        parcel.writeString(fr);
        parcel.writeString(ja);
        parcel.writeString(it);
    }
}
