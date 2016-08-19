package com.simpals.testtask.api;

import com.simpals.testtask.Model.City;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Vadim on 18.08.2016.
 */
public interface ApiCallback {
    void onSuccess(ArrayList<City> city) throws JSONException;
    void onFailure(Exception e);
}
