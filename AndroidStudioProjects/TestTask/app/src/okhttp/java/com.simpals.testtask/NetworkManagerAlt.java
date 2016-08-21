//package com.simpals.testtask;
//
//import android.content.Context;
//import android.os.AsyncTask;
//
//import com.google.gson.Gson;
//import com.simpals.testtask.api.ApiAlt;
//import com.simpals.testtask.api.ApiCallbackAlt;
//import com.simpals.testtask.model.CitiesInEurope;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//
//public class NetworkManagerAlt extends ApiAlt {
//
//    public NetworkManagerAlt(ApiCallbackAlt callbackAlt, Context context) {
//        super(callbackAlt, context);
//    }
//
//    private class RequestCitiesTask extends AsyncTask<Void, Void, String> {
//
//        private OkHttpClient client;
//        private Request request;
//        @Override
//        protected String doInBackground(Void... voids) {
//            Response response = null;
//            try {
//                response = client.newCall(request).execute();
//                return response.body().string();
//            } catch (IOException e) {
//                callbackAlt.onFailure(e);
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            client = new OkHttpClient();
//            request = new Request.Builder()
//                    .url(Constants.URL_EUR)
//                    .build();
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            if (s.isEmpty()) return;
//            super.onPostExecute(s);
//            try {
//                ArrayList<CitiesInEurope> cities = new ArrayList<CitiesInEurope>();
//                CitiesInEurope city;
//                JSONArray jsonArray = null;
//                try {
//                    jsonArray = new JSONArray(s);
//                    Gson gson = new Gson();
//                    for (int i = 0; i < jsonArray.length(); ++i) {
//                        JSONObject jsonCitiesInEurope = jsonArray.getJSONObject(i);
//                        city = gson.fromJson(jsonCitiesInEurope.toString(), CitiesInEurope.class);
//                        cities.add(city);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                callbackAlt.onSuccess(cities);
//            } catch (JSONException e) {
//                callbackAlt.onFailure(e);
//            }
//        }
//    }
//    public void requestAllCitiesInEurope() {
//        RequestCitiesTask requestTask = new RequestCitiesTask();
//        requestTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//    }
//}
//
