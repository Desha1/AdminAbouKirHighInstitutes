package com.example.adminaboukirhighinstitutes;


import java.io.Serializable;

public class Student implements Serializable {

    //Reference to student name
    private String name;

    private int sitNum, totalSum;
    //Reference to subject score
    private int sub1, sub2, sub3, sub4, sub5, sub6, sub7,sub8;
    //Reference to subject grade
    private String subGrade1, subGrade2, subGrade3, subGrade4, subGrade5, subGrade6, subGrade7, subGrade8;
    //Reference to subject name
    private String subName1, subName2, subName3, subName4, subName5, subName6, subName7, subName8;

    private String totalGrade;
    private int percentage;

    public Student() { }

    Student(String name, int sitNum, int sub1, int sub2, int sub3, int sub4, int sub5, int sub6, int sub7, int sub8) {
        this.name = name;
        this.sitNum = sitNum;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        this.sub7 = sub7;
        this.sub8 = sub8;
        this.subName1 = "sub1";
        this.subName2 = "sub2";
        this.subName3 = "sub3";
        this.subName4 = "sub4";
        this.subName5 = "sub5";
        this.subName6 = "sub6";
        this.subName7 = "sub7";
        this.subName8 = "sub8";

        setSubGrade1();
        setSubGrade2();
        setSubGrade3();
        setSubGrade4();
        setSubGrade5();
        setSubGrade6();
        setSubGrade7();
        setSubGrade8();

        setTotalSum();
        setPercentage();
        setTotalGrade();
    }

    Student(String name, int sitNum, int sub1, int sub2, int sub3, int sub4, int sub5, int sub6, int sub7) {
        this.name = name;
        this.sitNum = sitNum;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        this.sub7 = sub7;
        this.sub8 = -1;
        this.subName1 = "sub1";
        this.subName2 = "sub2";
        this.subName3 = "sub3";
        this.subName4 = "sub4";
        this.subName5 = "sub5";
        this.subName6 = "sub6";
        this.subName7 = "sub7";

        setSubGrade1();
        setSubGrade2();
        setSubGrade3();
        setSubGrade4();
        setSubGrade5();
        setSubGrade6();
        setSubGrade7();

        setTotalSum();
        setPercentage();
        setTotalGrade();
    }

    Student(String name, int sitNum, int sub1, int sub2, int sub3, int sub4, int sub5, int sub6) {
        this.name = name;
        this.sitNum = sitNum;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        this.sub7 = -1;
        this.sub8 = -1;
        this.subName1 = "sub1";
        this.subName2 = "sub2";
        this.subName3 = "sub3";
        this.subName4 = "sub4";
        this.subName5 = "sub5";
        this.subName6 = "sub6";
        this.subName7 = "sub7";

        setSubGrade1();
        setSubGrade2();
        setSubGrade3();
        setSubGrade4();
        setSubGrade5();
        setSubGrade6();

        setTotalSum();
        setPercentage();
        setTotalGrade();
    }

    Student(String name, int sitNum, int sub1, int sub2, int sub3, int sub4, int sub5) {
        this.name = name;
        this.sitNum = sitNum;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = -1;
        this.sub7 = -1;
        this.sub8 = -1;
        this.subName1 = "sub1";
        this.subName2 = "sub2";
        this.subName3 = "sub3";
        this.subName4 = "sub4";
        this.subName5 = "sub5";
        this.subName6 = "sub6";
        this.subName7 = "sub7";
        setSubGrade1();
        setSubGrade2();
        setSubGrade3();
        setSubGrade4();
        setSubGrade5();
        setSubGrade6();

        setTotalSum();
        setPercentage();
        setTotalGrade();
    }

    private void setTotalSum() {
        this.totalSum = sub1 + sub2 + sub3 + sub4 + sub5 + sub6 + sub7 + sub8;
    }

    private void setTotalGrade() {
        if (this.percentage >= 85) {
            this.totalGrade = "ممتاز";
        } else if (this.percentage >= 75) {
            this.totalGrade = "جيد جدا";
        } else if (this.percentage >= 65) {
            this.totalGrade = "جيد";
        } else if (this.percentage >= 50) {
            this.totalGrade = "مقبول";
        } else if (this.percentage < 49.9) {
            this.totalGrade = "ضعيف";
        }
    }

    private void setPercentage() {
        if (sub6 == -1)
            this.percentage = this.totalSum / 5;
        else if (sub7 == -1)
            this.percentage = this.totalSum / 6;
        else if (sub8 == -1)
            this.percentage = this.totalSum / 7;
        else
            this.percentage = this.totalSum / 8;
    }

    private String getGrade(int subjectScore) {
        String grade;
        if (subjectScore >= 85) {
            grade = "ممتاز";
        } else if (subjectScore >= 75) {
            grade = "جيد جدا";
        } else if (subjectScore >= 65) {
            grade = "جيد";
        } else if (subjectScore >= 50) {
            grade = "مقبول";
        } else if (subjectScore <= 49.9) {
            grade = "ضعيف";
        } else grade = "";

        return grade;
    }

    private void setSubGrade1() {
        this.subGrade1 = getGrade(sub1);
    }

    private void setSubGrade2() {
        this.subGrade2 = getGrade(sub2);
    }

    private void setSubGrade3() {
        this.subGrade3 = getGrade(sub3);
    }

    private void setSubGrade4() {
        this.subGrade4 = getGrade(sub4);
    }

    private void setSubGrade5() {
        this.subGrade5 = getGrade(sub5);
    }

    private void setSubGrade6() {
        if (sub6 == -1)
            this.subGrade6 = null;
        else
            this.subGrade6 = getGrade(sub6);
    }

    private void setSubGrade7() {
        if (sub7 == -1)
            this.subGrade7 = null;
        else
            this.subGrade7 = getGrade(sub7);
    }

    private void setSubGrade8() {
        if (sub8 == -1)
            this.subGrade8 = null;
        else
            this.subGrade8 = getGrade(sub8);
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

     int getSitNum() {
        return sitNum;
    }

     int getTotalSum() {
        return totalSum;
    }

     void setSubName1(String subName1) {
        this.subName1 = subName1;
    }

     void setSubName2(String subName2) {
        this.subName2 = subName2;
    }

     void setSubName3(String subName3) {
        this.subName3 = subName3;
    }

     void setSubName4(String subName4) {
        this.subName4 = subName4;
    }

     void setSubName5(String subName5) {
        this.subName5 = subName5;
    }

     void setSubName6(String subName6) {
        this.subName6 = subName6;
    }

     void setSubName7(String subName7) {
        this.subName7 = subName7;
    }


     String getSubName1() {
        return subName1;
    }

     String getSubName2() {
        return subName2;
    }

     String getSubName3() {
        return subName3;
    }

     String getSubName4() {
        return subName4;
    }

     String getSubName5() {
        return subName5;
    }

     String getSubName6() {
        return subName6;
    }

     String getSubName7() {
        return subName7;
    }

     String getSubName8() {
        return subName8;
    }

     String getSubGrade1() {
        return subGrade1;
    }

     String getSubGrade2() {
        return subGrade2;
    }

     String getSubGrade3() {
        return subGrade3;
    }

     String getSubGrade4() {
        return subGrade4;
    }

     String getSubGrade5() {
        return subGrade5;
    }

     String getSubGrade6() {
        return subGrade6;
    }

     String getSubGrade7() {
        return subGrade7;
    }

     String getSubGrade8() {
        return subGrade8;
    }

     String getTotalGrade() {
        return this.totalGrade;
    }

     int getPercentage() {
        return this.percentage;
    }
}
