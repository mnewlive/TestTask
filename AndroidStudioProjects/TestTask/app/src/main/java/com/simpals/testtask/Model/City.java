package com.simpals.testtask.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vadim on 18.08.2016.
 */
public class City implements Parcelable {

    private String city;
    private String county;
    private String description;
    private int zip;
    private String street_type;


    public String getCity() {
        return city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public String getCounty() {
        return county;
    }
}
