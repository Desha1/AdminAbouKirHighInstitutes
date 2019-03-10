package com.example.adminaboukirhighinstitutes;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Chose extends AppCompatActivity implements View.OnClickListener {

    private String getIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chose);

        defineAllElements();

    }

    public void defineAllElements() {
        Button putNewStudent = findViewById(R.id.put_new_student);
        Button showAllStudent = findViewById(R.id.show_all_student);

        getIntent = getIntent().getStringExtra("intent");

        putNewStudent.setOnClickListener(this);
        showAllStudent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {

            case R.id.put_new_student:
                if (isNetworkConnected()) {
                    intent = new Intent(this, NewStudentToFirebase.class);
                    intent.putExtra("intent", getIntent);
                    startActivity(intent);
                    break;
                } else
                    Toast.makeText(this, "Please connect to the network", Toast.LENGTH_LONG).show();


            case R.id.show_all_student:
                if (isNetworkConnected()) {
                    intent = new Intent(this, StudentsList.class);
                    intent.putExtra("intent", getIntent);
                    startActivity(intent);
                    break;
                } else
                    Toast.makeText(this, "Please connect to the network", Toast.LENGTH_LONG).show();

        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        assert cm != null;
        return cm.getActiveNetworkInfo() != null;
    }
}
