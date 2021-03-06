package com.simpals.testtask.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simpals.testtask.Constants;
import com.simpals.testtask.R;
import com.simpals.testtask.activities.DetailsOfCitiesInEur;
import com.simpals.testtask.model.CitiesInEurope;
import com.simpals.testtask.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 21.08.2016.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder> {

    List<CitiesInEurope> list;
    Activity activity;

    public CityAdapter(Activity activity, ArrayList<CitiesInEurope> list) {
        this.list = list;
        this.activity = activity;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView capital;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) itemView.findViewById(R.id.textViewName);
            capital = (TextView) itemView.findViewById(R.id.textViewCapital);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CitiesInEurope cities = list.get(getAdapterPosition());
                    Intent intent = new Intent(activity, DetailsOfCitiesInEur.class);
                    intent.putExtra((Constants.CITY), cities);
                    activity.startActivity(intent);
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_eur, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CitiesInEurope cities = list.get(position);
        holder.name.setText(cities.getName());
        holder.capital.setText(cities.getCapital());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
