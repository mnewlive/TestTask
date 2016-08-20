package com.simpals.testtask;

import android.content.Context;
import android.os.AsyncTask;


import com.simpals.testtask.model.City;
import com.simpals.testtask.utils.JSONParser;
import com.simpals.testtask.api.Api;
import com.simpals.testtask.api.ApiCallback;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class NetworkManager extends Api {

    public NetworkManager(ApiCallback callback, Context context) {
        super(callback, context);
    }

    private class RequestJobsTask extends AsyncTask<Void, Void, String> {
        private OkHttpClient client;
        private Request request;

        @Override
        protected String doInBackground(Void... voids) {
            Response response = null;
            try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                callback.onFailure(e);
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            client = new OkHttpClient();
            request = new Request.Builder()
                    .url(Constants.URL)
                    .build();
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.isEmpty()) return;
            super.onPostExecute(s);
            try {
                ArrayList<City> city = new ArrayList<City>();
                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(s);
                    city = new JSONParser().parseJSON(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callback.onSuccess(city);
            } catch (JSONException e) {
                callback.onFailure(e);
            }
        }
    }

    @Override
    public void requestAllJobs() {
        RequestJobsTask requestTask = new RequestJobsTask();
        requestTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}

