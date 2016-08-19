package com.simpals.testtask.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.simpals.testtask.Model.City;
import com.simpals.testtask.NetworkManager;
import com.simpals.testtask.R;
import com.simpals.testtask.Utils.ConnectionChecker;
import com.simpals.testtask.adapters.CityAdapter;
import com.simpals.testtask.api.ApiCallback;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Vadim on 18.08.2016.
 */
public class CityActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<City> city = new ArrayList<>();
    private CityAdapter cityAdapter;
    private Activity activity = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initRecyclerView();
        chooseSource();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!new ConnectionChecker().isInternet(this)) {
            getNetworkManager().requestAllJobs();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private NetworkManager getNetworkManager() {
        return new NetworkManager(new ApiCallback() {
            @Override
            public void onSuccess(ArrayList<City> cityList) throws JSONException {
                city = cityList;
                cityAdapter = new CityAdapter(activity, city);
                recyclerView.setAdapter(cityAdapter);
            }

            @Override
            public void onFailure(Exception e) {
                String dialogArray[] = {getResources().getString(R.string.try_again), getResources().getString(R.string.close)};
                if (!new ConnectionChecker().isInternet(getApplicationContext())) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(CityActivity.this)
                            .setTitle(R.string.error_connecting)
                            .setItems(dialogArray, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    switch (i) {
                                        case 0:
                                            getNetworkManager().requestAllJobs();
                                            break;
                                        case 1:
                                            finish();
                                            break;
                                    }
                                }
                            });
                    alertDialog.show();
                }
            }
        }, CityActivity.this);
    }

    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void chooseSource(){
        if (new ConnectionChecker().isInternet(this)) {
            NetworkManager networkManager = getNetworkManager();
            networkManager.requestAllJobs();
        }

    }
}
