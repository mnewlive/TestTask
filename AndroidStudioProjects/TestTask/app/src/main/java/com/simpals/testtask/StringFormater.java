package com.simpals.testtask;

import android.content.Context;

/**
 * Created by Vadim on 18.08.2016.
 */
public class StringFormater {

    Context context;

    public StringFormater(Context context) {
        this.context = context;
    }

    public String formatString(String str, int resId) {
        return String.format("%s %s", context.getResources().getString(resId), str);
    }
}
