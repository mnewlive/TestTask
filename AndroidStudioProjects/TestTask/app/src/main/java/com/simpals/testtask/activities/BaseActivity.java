package com.simpals.testtask.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.simpals.testtask.R;

/**
 * Created by Vadim on 19.08.2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected CallbackManager callbackManager;
    protected SharedPreferences sharedPreferences;
    protected static final String USER_SETTING = "userSetting";
    protected static final String USER_LOGGED_IN = "userLoggedIn";
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFacebookUtils();
        callbackManager = CallbackManager.Factory.create();
    }

    private void initFacebookUtils() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(getApplication());
    }
    protected void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
