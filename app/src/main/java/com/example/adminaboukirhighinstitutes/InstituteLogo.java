package com.example.adminaboukirhighinstitutes;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InstituteLogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institute_logo);

        int secondsDelayed = 2000;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(InstituteLogo.this, InstitutesName.class));
                finish();
            }
        }, secondsDelayed);
    }
}
