package com.simpals.testtask.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simpals.testtask.Constants;
import com.simpals.testtask.Model.City;
import com.simpals.testtask.R;
import com.simpals.testtask.activities.DetailsOfCityActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 18.08.2016.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder> {

    List<City> list;
    Activity activity;

    public CityAdapter(Activity activity, ArrayList<City> list) {
        this.list = list;
        this.activity = activity;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView county;

        public MyViewHolder(View view) {
            super(view);
            county = (TextView) itemView.findViewById(R.id.textViewCity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    City city = list.get(getAdapterPosition());
                    Intent intent = new Intent(activity, DetailsOfCityActivity.class);
                    intent.putExtra((Constants.CITY), city);
                    activity.startActivity(intent);
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        City city = list.get(position);
        holder.county.setText(city.getCounty());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
