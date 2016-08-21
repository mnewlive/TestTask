package com.simpals.testtask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.simpals.testtask.Constants;
import com.simpals.testtask.R;
import com.simpals.testtask.model.CitiesInEurope;
import com.simpals.testtask.utils.StringFormater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsOfCitiesInEur extends AppCompatActivity {


    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewCapital)
    TextView textViewCapital;
    @BindView(R.id.textViewRelevance)
    TextView textViewRelevance;
    @BindView(R.id.textViewRegion)
    TextView textViewRegion;
    @BindView(R.id.textViewSubregion)
    TextView textViewSubregion;
    @BindView(R.id.textViewPopulation)
    TextView textViewPopulation;
    @BindView(R.id.textViewDemonym)
    TextView textViewDemonym;
    @BindView(R.id.textViewNativeName)
    TextView textViewNativeName;
    @BindView(R.id.textViewAlpha2Code)
    TextView textViewAlpha2Code;
    @BindView(R.id.textViewAlpha3Code)
    TextView textViewAlpha3Code;
    @BindView(R.id.textViewLatlng)
    TextView textViewLatlng;

    CitiesInEurope citiesInEurope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_cities_in_eur);
        ButterKnife.bind(this);

        citiesInEurope = getIntent().getExtras().getParcelable(Constants.CITY);
        populateTextViews(citiesInEurope);
    }

    private void populateTextViews(CitiesInEurope citiesInEurope) {
        StringFormater stringFormater = new StringFormater(this);
        textViewName.setText(stringFormater.formatString(citiesInEurope.getName(), R.string.name));
        textViewCapital.setText(stringFormater.formatString(citiesInEurope.getCapital(), R.string.capital));
        textViewRelevance.setText(stringFormater.formatString(citiesInEurope.getRelevance(), R.string.relevance));
        textViewRegion.setText(stringFormater.formatString(citiesInEurope.getRegion(), R.string.region));
        textViewSubregion.setText(stringFormater.formatString(citiesInEurope.getSubregion(), R.string.subregion));
        textViewPopulation.setText(stringFormater.formatString(citiesInEurope.getPopulation(), R.string.population));
        textViewDemonym.setText(stringFormater.formatString(citiesInEurope.getDemonym(), R.string.denonym));
        textViewNativeName.setText(stringFormater.formatString(citiesInEurope.getNativeName(), R.string.native_name));
        textViewAlpha2Code.setText(stringFormater.formatString(citiesInEurope.getAlpha2Code(), R.string.aplha_code_2));
        textViewAlpha3Code.setText(stringFormater.formatString(citiesInEurope.getAlpha3Code(), R.string.aplha_code_3));
        textViewLatlng.setText(stringFormater.formatString(citiesInEurope.getLatlng(), R.string.latlng));
    }
}
