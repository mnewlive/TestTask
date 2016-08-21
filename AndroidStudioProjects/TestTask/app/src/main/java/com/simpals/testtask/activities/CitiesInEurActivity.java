package com.simpals.testtask.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;

import com.simpals.testtask.R;
import com.simpals.testtask.adapters.CityAdapter;
import com.simpals.testtask.model.CitiesInEurope;

import java.util.ArrayList;

public class CitiesInEurActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<CitiesInEurope> cities = new ArrayList<>();
    private CityAdapter cityAdapter;
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_in_eur);
        initRecyclerView();
        //  chooseSource();
        initNavigationView();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (!new ConnectionChecker().isInternet(this)) {
//            getNetworkManagerAlt().requestAllCitiesInEurope();
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    private NetworkManagerAlt getNetworkManagerAlt() {
//        return new NetworkManagerAlt(new ApiCallbackAlt() {
//            @Override
//            public void onSuccess(ArrayList<CitiesInEurope> cityList) throws JSONException {
//                cities = cityList;
//                cityAdapter = new CityAdapter(activity, cities);
//                recyclerView.setAdapter(cityAdapter);
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                String dialogArray[] = {getResources().getString(R.string.try_again), getResources().getString(R.string.close)};
//                if (!new ConnectionChecker().isInternet(getApplicationContext())) {
//                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(CitiesInEurActivity.this)
//                            .setTitle(R.string.error_connecting)
//                            .setItems(dialogArray, new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    switch (i) {
//                                        case 0:
//                                            getNetworkManagerAlt().requestAllCitiesInEurope();
//                                            break;
//                                        case 1:
//                                            finish();
//                                            break;
//                                    }
//                                }
//                            });
//                    alertDialog.show();
//                }
//            }
//        }, CitiesInEurActivity.this);
//    }

//    private void chooseSource() {
//        if (new ConnectionChecker().isInternet(this)) {
//            NetworkManagerAlt networkManager = getNetworkManagerAlt();
//            networkManager.requestAllCitiesInEurope();
//        }
//    }

    protected void initNavigationView() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_menu_1:
                start(CityActivity.class);
                break;
            case R.id.nav_menu_2:
                start(CitiesInEurActivity.class);
                break;
        }
        return false;
    }

    private void start(Class activity) {
        startActivity(new Intent(CitiesInEurActivity.this, activity));
    }
}