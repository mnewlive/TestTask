package com.simpals.testtask.utils;

import com.google.gson.Gson;
import com.simpals.testtask.model.City;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser {

    public ArrayList<City> parseJSON(JSONArray jsonArray) throws JSONException {
        City city;
        ArrayList<City> cities = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsonCity = jsonArray.getJSONObject(i);
            city = gson.fromJson(jsonCity.toString(), City.class);
            cities.add(city);
        }
        return cities;
    }
}
