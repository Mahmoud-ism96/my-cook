package com.example.mycook.startup.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycook.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}