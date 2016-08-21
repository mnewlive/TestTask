package com.simpals.testtask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 21.08.2016.
 */
public class CitiesInEurope implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    private List<String> altSpellings = new ArrayList<String>();
    @SerializedName("relevance")
    @Expose
    private String relevance;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("translations")
    @Expose
    private Translations translations;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("latlng")
    @Expose
    private String latlng;
    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private Double area;
    @SerializedName("borders")
    @Expose
    private List<Object> borders = new ArrayList<Object>();
    @SerializedName("nativeName")
    @Expose
    private String nativeName;
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = new ArrayList<String>();
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = new ArrayList<String>();
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("currencies")
    @Expose
    private List<String> currencies = new ArrayList<String>();
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRelevance() {
        return relevance;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public Translations getTranslations() {
        return translations;
    }

    public String getPopulation() {
        return population;
    }

    public String getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public Double getArea() {
        return area;
    }


    public List<Object> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public static Creator<CitiesInEurope> getCREATOR() {
        return CREATOR;
    }

    public CitiesInEurope() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.capital);
        dest.writeStringList(this.altSpellings);
        dest.writeString(this.relevance);
        dest.writeString(this.region);
        dest.writeString(this.subregion);
        dest.writeParcelable(this.translations, flags);
        dest.writeString(this.population);
        dest.writeString(this.latlng);
        dest.writeString(this.demonym);
        dest.writeValue(this.area);
        dest.writeList(this.borders);
        dest.writeString(this.nativeName);
        dest.writeStringList(this.callingCodes);
        dest.writeStringList(this.topLevelDomain);
        dest.writeString(this.alpha2Code);
        dest.writeString(this.alpha3Code);
        dest.writeStringList(this.currencies);
        dest.writeStringList(this.languages);
    }

    protected CitiesInEurope(Parcel in) {
        this.name = in.readString();
        this.capital = in.readString();
        this.altSpellings = in.createStringArrayList();
        this.relevance = in.readString();
        this.region = in.readString();
        this.subregion = in.readString();
        this.translations = in.readParcelable(Translations.class.getClassLoader());
        this.population = in.readString();
        this.latlng = in.readString();
        this.demonym = in.readString();
        this.area = (Double) in.readValue(Double.class.getClassLoader());
        this.borders = new ArrayList<Object>();
        in.readList(this.borders, Object.class.getClassLoader());
        this.nativeName = in.readString();
        this.callingCodes = in.createStringArrayList();
        this.topLevelDomain = in.createStringArrayList();
        this.alpha2Code = in.readString();
        this.alpha3Code = in.readString();
        this.currencies = in.createStringArrayList();
        this.languages = in.createStringArrayList();
    }

    public static final Creator<CitiesInEurope> CREATOR = new Creator<CitiesInEurope>() {
        @Override
        public CitiesInEurope createFromParcel(Parcel source) {
            return new CitiesInEurope(source);
        }

        @Override
        public CitiesInEurope[] newArray(int size) {
            return new CitiesInEurope[size];
        }
    };
}
