package com.simpals.testtask.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.simpals.testtask.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(USER_SETTING, Context.MODE_PRIVATE);
        if (!sharedPreferences.getBoolean(USER_LOGGED_IN, false)) {
            setContentView(R.layout.activity_main);
            initLoginButton();
        } else {
            startCityActivity();
        }
    }

    private void initLoginButton() {
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, getCallback());
    }


    private FacebookCallback<LoginResult> getCallback() {
        return new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                sharedPreferences.edit().putBoolean(USER_LOGGED_IN, true).apply();
                startCityActivity();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.on_cancel_message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(getApplicationContext(), R.string.on_error_message, Toast.LENGTH_SHORT).show();
            }
        };
    }


    private void startCityActivity() {
        startActivity(new Intent(getApplicationContext(), CityActivity.class));
        finish();
    }
}
