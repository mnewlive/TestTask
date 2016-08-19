package com.simpals.testtask;

import android.content.Context;


import com.simpals.testtask.Model.City;
import com.simpals.testtask.api.Api;
import com.simpals.testtask.api.ApiCallback;

import org.json.JSONException;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;


/**
 * Created by vmorozov on 7/22/16.
 */
public class NetworkManager extends Api {

    public static final String CITY = "City: ";

    public NetworkManager(ApiCallback callback, Context context) {
        super(callback, context);
    }

    public interface GetJobsInterface {
        @GET(CITY)
        Call<List<City>> getList();
    }

    @Override
    public void requestAllJobs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetJobsInterface myApi = retrofit.create(GetJobsInterface.class);
        Call<List<City>> city = myApi.getList();
        city.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                try {
                    callback.onSuccess((ArrayList<City>) response.body());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                callback.onFailure((Exception)t);
            }
        });
    }
}