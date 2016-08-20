package com.simpals.testtask.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Vadim on 19.08.2016.
 */
public class ConnectionChecker {
    public boolean isInternet(Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() == null;
    }
}
