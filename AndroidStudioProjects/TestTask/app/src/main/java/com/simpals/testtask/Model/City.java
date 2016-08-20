package com.simpals.testtask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Vadim on 18.08.2016.
 */
public class City implements Parcelable {

    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("street_type")
    @Expose
    private String streetType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("sector")
    @Expose
    private String sector;

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }


    protected City(Parcel in) {
        county = in.readString();
        location = in.readString();
        streetType = in.readString();
        description = in.readString();
        zip = in.readString();
        sector = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(county);
        parcel.writeString(location);
        parcel.writeString(streetType);
        parcel.writeString(description);
        parcel.writeString(zip);
        parcel.writeString(sector);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}


