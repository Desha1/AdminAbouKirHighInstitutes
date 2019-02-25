package com.example.adminaboukirhighinstitutes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InstitutesName extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institutes_name);
        defineAllElements();
    }
    public void defineAllElements (){
        TextView hicis = findViewById(R.id.hicis);
        TextView hith = findViewById(R.id.hith);
        TextView himr = findViewById(R.id.himr);
        hicis.setOnClickListener(this);
        hith.setOnClickListener(this);
        himr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,EducationalYears.class);
        switch (v.getId()){

            case R.id.hicis:
                intent.putExtra("intent","hicis");
                startActivity(intent);
                break;

            case R.id.hith:
                intent.putExtra("intent","hith");
                startActivity(intent);
                break;

            case R.id.himr:
                intent.putExtra("intent","himr");
                startActivity(intent);
                break;
        }

    }
}
