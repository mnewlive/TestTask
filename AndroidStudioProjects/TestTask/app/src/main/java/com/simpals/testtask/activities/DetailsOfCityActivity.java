package com.simpals.testtask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.simpals.testtask.Constants;
import com.simpals.testtask.model.City;
import com.simpals.testtask.R;
import com.simpals.testtask.utils.StringFormater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsOfCityActivity extends AppCompatActivity implements OnMapReadyCallback {


    @BindView(R.id.textViewCounty)
    TextView textViewCounty;
    @BindView(R.id.textViewLocation)
    TextView textViewLocation;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.textViewZip)
    TextView textViewZip;
    @BindView(R.id.textViewStreetType)
    TextView textViewStreetType;
    @BindView(R.id.textViewSector)
    TextView textViewSector;

    GoogleMap map;
    City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_city);
        ButterKnife.bind(this);

        city = getIntent().getExtras().getParcelable(Constants.CITY);
        populateTextViews(city);

        initMap();

    }

    private void populateTextViews(City city) {
        StringFormater stringFormater = new StringFormater(this);
        textViewCounty.setText(stringFormater.formatString(city.getCounty(), R.string.county_name));
        textViewLocation.setText(stringFormater.formatString(city.getLocation(), R.string.location));
        textViewDescription.setText(stringFormater.formatString(city.getDescription(), R.string.description));
        textViewZip.setText(stringFormater.formatString(city.getZip(), R.string.zip_code));
        textViewStreetType.setText(stringFormater.formatString(city.getStreetType(), R.string.street_type));
        textViewSector.setText(stringFormater.formatString(city.getSector(), R.string.sector));
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    // Made example for 4 task
    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (!city.getLocation().equals("")) {
            LatLng location = new LatLng(Double.parseDouble(city.getLocation()),
                    Double.parseDouble(city.getLocation()));
            map.addMarker(new MarkerOptions().position(location).title(city.getCounty()));
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(location)
                    .zoom(10)
                    .build();
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_content, null);
                TextView viewDescription = (TextView) v.findViewById(R.id.textViewDescription);
                TextView viewCounty = (TextView) v.findViewById(R.id.textViewCounty);
                viewDescription.setText(textViewLocation.getText().toString());
                viewCounty.setText(city.getCounty());
                return v;
            }
        });
    }
}
