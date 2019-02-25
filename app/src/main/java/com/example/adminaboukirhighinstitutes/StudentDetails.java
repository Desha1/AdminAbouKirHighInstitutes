package com.example.adminaboukirhighinstitutes;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminaboukirhighinstitutes.R;
import com.example.adminaboukirhighinstitutes.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class StudentDetails extends AppCompatActivity {

    TextView studentName, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8,
            totalAppreciation, sitNum, totalSum, percentage;
    TextView subjectName1, subjectName2, subjectName3, subjectName4, subjectName5, subjectName6, subjectName7, subjectName8;
    ConstraintLayout lastSub6, lastSub7, lastSub8;
    Student studentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);
        // Define All Elements
        defineAllElements();

        getDataFromStudentList();
    }

    private void defineAllElements() {
        // Define All Elements
        lastSub6 = findViewById(R.id.subject6_layout);
        lastSub7 = findViewById(R.id.subject7_layout);
        lastSub8 = findViewById(R.id.subject8_layout);
        studentName = findViewById(R.id.student_name);
        sitNum = findViewById(R.id.sit_num);
        subject1 = findViewById(R.id.sub1);
        subject2 = findViewById(R.id.sub2);
        subject3 = findViewById(R.id.sub3);
        subject4 = findViewById(R.id.sub4);
        subject5 = findViewById(R.id.sub5);
        subject6 = findViewById(R.id.sub6);
        subject7 = findViewById(R.id.sub7);
        subject8 = findViewById(R.id.sub8);
        subjectName1 = findViewById(R.id.sub1_text);
        subjectName2 = findViewById(R.id.sub2_text);
        subjectName3 = findViewById(R.id.sub3_text);
        subjectName4 = findViewById(R.id.sub4_text);
        subjectName5 = findViewById(R.id.sub5_text);
        subjectName6 = findViewById(R.id.sub6_text);
        subjectName7 = findViewById(R.id.sub7_text);
        subjectName8 = findViewById(R.id.sub8_text);
        totalAppreciation = findViewById(R.id.total_appreciation);
        totalSum = findViewById(R.id.total_sum);
        percentage = findViewById(R.id.percent);
        //End Of Define All Elements
    }

    private void getDataFromStudentList() {
        // Get Data From Student List
        studentData = (Student) getIntent().getSerializableExtra("studentData");

        lastSubjectFoundCondition();

        studentName.setText(studentData.getName());
        sitNum.setText(String.valueOf(studentData.getSitNum()));

        subjectName1.setText(studentData.getSubName1());
        subjectName2.setText(studentData.getSubName2());
        subjectName3.setText(studentData.getSubName3());
        subjectName4.setText(studentData.getSubName4());
        subjectName5.setText(studentData.getSubName5());
        subjectName6.setText(studentData.getSubName6());
        subjectName7.setText(studentData.getSubName7());
        subjectName8.setText(studentData.getSubName8());

        subject1.setText(String.valueOf(studentData.getSubGrade1()));
        subject2.setText(String.valueOf(studentData.getSubGrade2()));
        subject3.setText(String.valueOf(studentData.getSubGrade3()));
        subject4.setText(String.valueOf(studentData.getSubGrade4()));
        subject5.setText(String.valueOf(studentData.getSubGrade5()));
        subject6.setText(String.valueOf(studentData.getSubGrade6()));
        subject7.setText(String.valueOf(studentData.getSubGrade7()));
        subject8.setText(String.valueOf(studentData.getSubGrade8()));

        totalAppreciation.setText(studentData.getTotalGrade());
        totalSum.setText(String.valueOf(studentData.getTotalSum()));
        percentage.setText(String.format("%s%%", String.valueOf(studentData.getPercentage())));
    }

    private void lastSubjectFoundCondition() {
        if (studentData.getSubGrade6() == null)
            lastSub6.setVisibility(View.GONE);

        if (studentData.getSubGrade7() == null)
            lastSub7.setVisibility(View.GONE);

        if (studentData.getSubGrade8() == null)
            lastSub8.setVisibility(View.GONE);
    }
}
