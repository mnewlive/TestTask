package com.simpals.testtask.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.simpals.testtask.model.City;
import com.simpals.testtask.NetworkManager;
import com.simpals.testtask.R;
import com.simpals.testtask.utils.ConnectionChecker;
import com.simpals.testtask.adapters.CityAdapter;
import com.simpals.testtask.api.ApiCallback;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Vadim on 18.08.2016.
 */
public class CityActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private ArrayList<City> city = new ArrayList<>();
    private CityAdapter cityAdapter;
    private Activity activity = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initRecyclerView();
        chooseSource();
        initNavigationView();
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

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void chooseSource() {
        if (new ConnectionChecker().isInternet(this)) {
            NetworkManager networkManager = getNetworkManager();
            networkManager.requestAllJobs();
        }
    }

    private void initNavigationView() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_menu_1:
                Toast.makeText(CityActivity.this, R.string.city_rom, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu_2:
                Toast.makeText(CityActivity.this, R.string.city_eur, Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
