package com.simpals.testtask.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.simpals.testtask.Constants;
import com.simpals.testtask.Model.City;
import com.simpals.testtask.R;
import com.simpals.testtask.StringFormater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsOfCityActivity extends AppCompatActivity {

    @BindView(R.id.textViewCounty)
    TextView textViewCounty;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.textViewZip)
    TextView textViewZip;
    @BindView(R.id.textViewStreetType)
    TextView textViewStreetType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_city);
        ButterKnife.bind(this);

        Intent intent =getIntent();
        City city = intent.getExtras().getParcelable(Constants.CITY);
        populateTextViews(city);

    }

    private void populateTextViews(City city) {
        StringFormater stringFormater = new StringFormater(this);
        textViewCounty.setText(stringFormater.formatString(city.getCounty(), R.string.county_name));
        textViewDescription.setText(stringFormater.formatString(city.getCounty(), R.string.description));
        textViewZip.setText(stringFormater.formatString(city.getCounty(), R.string.zip_code));
        textViewStreetType.setText(stringFormater.formatString(city.getCounty(), R.string.street_type));

    }
}
