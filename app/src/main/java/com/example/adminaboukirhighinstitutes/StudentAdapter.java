package com.example.adminaboukirhighinstitutes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter  extends RecyclerView.Adapter<StudentViewHolder> {

    private Context context;
    private ArrayList<Student> allStudent;
    private StudentDetails studentDetails;

    public StudentAdapter(Context context, ArrayList<Student> allStudent) {
        this.context = context;
        this.allStudent = allStudent;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_design,viewGroup,false);
        return new StudentViewHolder(view);
    }

    void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, @SuppressLint("RecyclerView") final int i) {

        studentViewHolder.setData(allStudent.get(i));
        studentViewHolder.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDetails.onStudent(i);
            }
        });
    }
    interface StudentDetails{
        void onStudent(int position);
    }


    @Override
    public int getItemCount() {
        return allStudent.size();
    }
}

class StudentViewHolder extends RecyclerView.ViewHolder {



    private TextView name, sitNum, totalSum;
    private LinearLayout root;

    LinearLayout getRoot() {
        return root;
    }

    StudentViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.student_name);
        sitNum = itemView.findViewById(R.id.sit_num);
        totalSum = itemView.findViewById(R.id.total_sum);
        root = itemView.findViewById(R.id.root);
    }

    void setData(Student student){

        name.setText(student.getName());
        sitNum.setText(String.valueOf(student.getSitNum()));
        totalSum.setText(String.valueOf(student.getTotalSum()));
    }
}