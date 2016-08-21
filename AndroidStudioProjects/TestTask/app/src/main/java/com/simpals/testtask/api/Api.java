package com.simpals.testtask.api;

import android.content.Context;

/**
 * Created by Vadim on 18.08.2016.
 */
public abstract class Api {

    protected ApiCallback callback;
    protected Context context;

    public Api(ApiCallback callback, Context context) {
        this.callback = callback;
        this.context = context;
    }
    public abstract void requestAllCities();
}
