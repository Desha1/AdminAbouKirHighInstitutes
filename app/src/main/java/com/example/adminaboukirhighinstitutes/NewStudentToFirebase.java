package com.example.adminaboukirhighinstitutes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.adminaboukirhighinstitutes.R.string.arabic;
import static com.example.adminaboukirhighinstitutes.R.string.english;

public class NewStudentToFirebase extends AppCompatActivity implements View.OnClickListener {

    private String getIntent;
    private EditText sitNum, name, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8;
    private String subName1, subName2, subName3, subName4, subName5, subName6, subName7, subName8;
    Switch division;
    DatabaseReference database;
    Button upload;
    RadioGroup radioGroup;
    private Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_student_to_firebase);

        defineAllElements();


        if (getIntent.contains("hicis")) {
            division.setVisibility(View.VISIBLE);
            division.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        division.setText(arabic);
                        arabicSetSubjectNamesAndNumberOfSubjectHICIS();
                    } else {
                        division.setText(english);
                        englishSetSubjectNamesAndNumberOfSubjectHICIS();
                    }
                }
            });
        }else if (getIntent.contains("hith")) {
            radioGroup.setVisibility(View.VISIBLE);
            if (R.id.tourism == onRadioButtonClick())
                tourismSetSubjectNamesAndNumberOfSubjectHITH();
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (R.id.tourism == onRadioButtonClick()) {
                        tourismSetSubjectNamesAndNumberOfSubjectHITH();
                    } else if (R.id.hotels == onRadioButtonClick()) {
                        hotelsSetSubjectNamesAndNumberOfSubjectHITH();
                    } else if (R.id.tourism_guiding == onRadioButtonClick()) {
                        tourismGuidingSetSubjectNamesAndNumberOfSubjectHITH();
                    }
                }
            });
        }else if (getIntent.contains("himr")) {
            setSubjectNamesAndNumberOfSubjectHIRM();
        }

        upload.setOnClickListener(this);
    }

    private void defineAllElements() {
        getIntent = getIntent().getStringExtra("intent");

        sitNum = findViewById(R.id.sit_num);
        name = findViewById(R.id.name);
        sub1 = findViewById(R.id.sub1);
        sub2 = findViewById(R.id.sub2);
        sub3 = findViewById(R.id.sub3);
        sub4 = findViewById(R.id.sub4);
        sub5 = findViewById(R.id.sub5);
        sub6 = findViewById(R.id.sub6);
        sub7 = findViewById(R.id.sub7);
        sub8 = findViewById(R.id.sub8);
        division = findViewById(R.id.switch_division);
        division.setVisibility(View.GONE);
        upload = findViewById(R.id.upload);
        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setVisibility(View.GONE);
        subName1 = "";
        subName2 = "";
        subName3 = "";
        subName4 = "";
        subName5 = "";
        subName6 = "";
        subName7 = "";
        subName8 = "";
        database = FirebaseDatabase.getInstance().getReference();
    }

    private void arabicSetSubjectNamesAndNumberOfSubjectHICIS() {
        switch (getIntent) {
            case "hicisFirstYearFirstSemester":
                setSubjectsName("مقدمة في الحاسبات", "مقدمة في نظم التشغيل", "المبادئ المحاسبية",
                        "مبادئ السلوك التنظيمي", "مبادئ الإقتصاد", "مراسلات ومصطلحات باللغة الإنجليزية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisFirstYearSecondSemester":
                setSubjectsName("أساسيات البرمجة الهيكلية", "حزم التطبيقات المكتبية",
                        "إدارة عامة", "مبادئ تنظيم وإدارة", "الرياضيات والتأمين", "مراسلات ومصطلحات باللغة الإنجليزية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisSecondYearFirstSemester":
                setSubjectsName("تسويق", "رياضة وتمويل", "إحصاء", "نظم المعلومات الإدارية", "دراسات اقتصادية باللغة الإنجليزية");
                sub6.setVisibility(View.GONE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisSecondYearSecondSemester":
                setSubjectsName("تطبيقات الإنترنت والوسائط المتعددة", "إدارة الإنتاج", "قانون تجاري",
                        "البرمجة الهيكلية المتقدمة", "محاسبة شركات", "قواعد بيانات (1)", "دراسات إقتصادية باللغة الإنجليزية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                break;
            case "hicisThirdYearFirstSemester":
                setSubjectsName("قواعد البيانات (2)", "احصاء وبحوث عمليات", "محاسبة ضرائب", "اقتصاد كلي", "محاسبة تكاليف", "دراسات إنجليزية باللغة الإنجليزية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisThirdYearSecondSemester":
                setSubjectsName("التسويق وتجارة إلكترونية", "إدارة المشتريات والمخازن", "إقتصاد كلي", "محاسبة تكاليف", "تحليل نظم المعلومات", "دراسات إقتصادية باللغة الإنجليزية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisFourthYearFirstSemester":
                setSubjectsName("شبكات وأمن المعلومات", "دراسة الجدوى الإقتصادية", "دراسات محاسبية باللغة الإنجليزية", "محاسبة إدارية", "إدارة الأفراد");
                sub6.setVisibility(View.GONE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisFourthYearSecondSemester":
                setSubjectsName("نظم دعم القرار", "نظم المعلومات المحاسبية", "إدارة المؤسسات والتمويل", "تطبيقات الحاسب في إعداد التقارير", "دراسات محاسبية باللغة الإنجليزية", "المشروع");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
        }
    }

    private void englishSetSubjectNamesAndNumberOfSubjectHICIS() {
        switch (getIntent) {
            case "hicisFirstYearFirstSemester":
                setSubjectsName("Introduction to Computers", "Introduction to Operating System", "Principles of Economics", "Introduction to Business" +
                        "Administration", "Public Administration", "Correspondence & English Terminology");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisFirstYearSecondSemester":
                setSubjectsName("Fundamentals of Structural Programing", "Office Application Packages", "Principles of Accounting", "Mathematics &" +
                        "Insurance", "Principles of Organizational Behavior", "Correspondence & English Terminology");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisSecondYearFirstSemester":
                setSubjectsName("Database (1)", "Advanced Structural Programing", "Accounting for Companies", "Production Management", "Business Law"
                        , "Studies in Economics & in English");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisSecondYearSecondSemester":
                setSubjectsName("Management Information System", "Internet & Multi Media Applications", "Marketing", "Financial Mathematics",
                        "Statistics", "Studies in Economics & in English");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisThirdYearFirstSemester":
                setSubjectsName("Database (2)", "Statistics & Operation Research Packages", "Tax Accounting", "Production Management", "Macro Accounting"
                        , "Management Studies in English");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisThirdYearSecondSemester":
                setSubjectsName("Information System Analysis & Design", "Marketing & Electronic Commerce", "Purchasing & Inventory Management"
                        , "Macro Economics", "Cost Accounting", "Management Studies in English");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisFourthYearFirstSemester":
                setSubjectsName("Decision Support System", "Network & Information Security", "Personal Management", "Management in Accounting"
                        , "Studies in Accounting in English");
                sub6.setVisibility(View.GONE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hicisFourthYearSecondSemester":
                setSubjectsName("Computer Applications for Reports preparations", "Accounting Information System", "Finance & Financial Institutions" +
                        "Management", "Feasibility Studies", "Studies in Accounting in English", "Graduation Project");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
        }
    }

    private void tourismSetSubjectNamesAndNumberOfSubjectHITH() {
        switch (getIntent) {
            case "hithFirstYearFirstSemester":
                setSubjectsName("مدخل إلى علم السياحة", "مبادئ صناعة الضيافة", "تاريخ مصر القديم ومواقعها الأثرية", "مبادئ الإقتصاد", "لغة أجنبية أولى متخصصة", "لغة أجنبية ثانية متخصصة");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFirstYearSecondSemester":
                setSubjectsName("جغرافيا سياحية", "البيئة المصرية", "صحة عامة", "مبادئ الإدارة", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithSecondYearFirstSemester":
                setSubjectsName("الحاسب الآلي", "مبادئ المحاسبة", "مبادئ الإحصاء", "إدارة المكاتب السياحية", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithSecondYearSecondSemester":
                setSubjectsName("السياحة المحلية والدولية", "الإحصاء السياحي والفندقي", "محاسبة شركات السياحة", "شركات السياحة (1)", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithThirdYearFirstSemester":
                setSubjectsName("الأجهوة والمنظمات السياحية", "التشريعات السياحية والفندقية", "اقتصاديات السياحة", "شركات السياحة (2)", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithThirdYearSecondSemester":
                setSubjectsName("الإتجاهات الحديثة في السياحة", "السياحة البيئية", "تنمية المبيعات السياحية", "شركات الطيران (1)", "التخطيط السياحي", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);

                break;
            case "hithFourthYearFirstSemester":
                setSubjectsName("دراسة جدوى المشروعات", "شركات الطيران (2)", "التنمية السياحية", "إقتصاديات النقل السياحي", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFourthYearSecondSemester":
                setSubjectsName("التسويق السياحي", "الإعلام السياحي", "مراسلات سياحية باللغة الأجنبية", "المشروع السياحي", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
        }
    }

    private void hotelsSetSubjectNamesAndNumberOfSubjectHITH() {
        switch (getIntent) {
            case "hithFirstYearFirstSemester":
                setSubjectsName("مدخل إلى علم السياحة", "مبادئ صناعة الضيافة", "تاريخ مصر القديم ومواقعها الأثرية", "مبادئ الإقتصاد", "لغة أجنبية أولى متخصصة", "لغة أجنبية ثانية متخصصة");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFirstYearSecondSemester":
                setSubjectsName("جغرافيا سياحية", "البيئة المصرية", "صحة عامة", "مبادئ الإدارة", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithSecondYearFirstSemester":
                setSubjectsName("الحاسب الآلي", "مبادئ المحاسبة", "مبادئ الإحصاء", "إدارة الفنادق", "فن الطهي الفندقي (1)", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithSecondYearSecondSemester":
                setSubjectsName("محاسبة فندقية", "الإحصاء السياحي والفندقي", "خدمة الطعام", "تغذية وقوائم الطعام", "فن الطي الفندقي (2)", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithThirdYearFirstSemester":
                setSubjectsName("الأجهزة والمنظمات السياحية", "التشريت السياحية والفندقية", "محاسبة تكاليف", "المكاتب الأمامية", "أغذية ومشروبات", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithThirdYearSecondSemester":
                setSubjectsName("التجهيزات الفندقية", "اقتصادات الفنادق", "شراء واستلام الخامات الغذائية", "إشراف داخلي", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFourthYearFirstSemester":
                setSubjectsName("دراسة جدوى المشروعات", "إدارة الحفلات والمؤتمرات", "تخزين المأكولات", "صيانة فندقية", "تغذية الجماعات", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFourthYearSecondSemester":
                setSubjectsName("التسويق الفندقي", "الفندقية العلاجية", "صحة فندقية", "المشروع الفندقي", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
        }
    }

    private void tourismGuidingSetSubjectNamesAndNumberOfSubjectHITH() {
        switch (getIntent) {
            case "hithFirstYearFirstSemester":
                setSubjectsName("مدخل إلى علم السياحة", "مبادئ صناعة الضيافة", "تاريخ مصر القديم ومواقعها الأثرية", "مبادئ الإقتصاد", "لغة أجنبية أولى متخصصة", "لغة أجنبية ثانية متخصصة");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFirstYearSecondSemester":
                setSubjectsName("جغرافيا سياحية", "البيئة المصرية", "صحة عامة", "مبادئ الإدارة", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithSecondYearFirstSemester":
                setSubjectsName("تاريخ مصر الفرعونية (1)", "آثار مصرية فرعونية (1)", "متاحف", "ديانة مصرية قديمة", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithSecondYearSecondSemester":
                setSubjectsName("تاريخ مصر الفرعونية (2)", "آثار مصرية فرعونية (2)", "لغة مصرية قديمة (1)", "إرشاد سياحي تطبيقي", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithThirdYearFirstSemester":
                setSubjectsName("الأجهزة والمنظمات السياحية", "التشريعات السياحية والفندقية", "تاريخ مصر الفرعونية (3)", "آثار مصرية فرعونية (3)", "تاريخ مصر اليونانية والرومانية", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithThirdYearSecondSemester":
                setSubjectsName("آثار مصر الفرعونية", "آثار مصر اليونانية والرومانية", "لغة مصرية قديمة (1)", "إرشاد سياحي تطبيقي", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFourthYearFirstSemester":
                setSubjectsName("تاريخ مصر الإسلامية", "آثار مصر الإسلامية", "تاريخ مصر الحديثة", "معالم مصر الحديثة", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "hithFourthYearSecondSemester":
                setSubjectsName("تاريخ مصر المعاصر", "آثار مصر الإسلامية", "فنون إسلامية", "لغة مصرية قديمة (3)", "إرشاد سياحي تطبيقي (3)", "لغة أجنبية متخصصة أولى", "لغة أجنبية متخصصة ثانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
        }
    }

    private void setSubjectNamesAndNumberOfSubjectHIRM() {
        switch (getIntent) {
            case "himrFirstYearFirstSemester":
                setSubjectsName("معالم تاريخ مصر القديم", "تاريخ مصر الإسلامية", "آثار وحضارة إسلامية", "مبادئ ترميمي الآثار", "لغة أوروبية حديثة - قواعد وتمرينات", "أعمال السنة (آثار وحضارة إسلامية)", "تدريبات ميدانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "himrFirstYearSecondSemester":
                setSubjectsName("تاريخ الفن", "آثار وحضارة مصرية قديمة", "معدنيات وصخور", "أعمال جص", "قراءات أثرية بلغة أوربية", "أعمال السنة (آثار وحضارة مصرية قديمة)", "تدريبات ميدانية");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "himrSecondYearFirstSemester":
                setSubjectsName("مساحة ورسم معماري", "كيمياء وطبيعة عامة", "نون مصرية قديمة وقبطية", "حفر وتشكيل الأخشاب", "علاج وصيانة الأحجار", "لغة أوربية حديثة - قواعد وتمرينات", "تقنيات التصوير الزيتي", "أعمال السنة (دراسات وبحوث)");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.VISIBLE);
                break;
            case "himrSecondYearSecondSemester":
                setSubjectsName("رسم زخرفي", "تكنولوجيا المواد والصناعات القديمة (غير عضوية)", "مبادئ اللغة المصرية القديمة", "ترميم وصيانة مباني أثرية", "ترميم وصيانة أخشاب", "ترميم لوحات زيتية", "قراءات وترميم الآثار بلغة حديثة", "أعمال السنة (دراسات وبحوث)");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.VISIBLE);
                break;
            case "himrThirdYearFirstSemester":
                setSubjectsName("كيمياء وطبيعة تطبيقية", "أعمال جص", "علاج وصيانة المخطوطات", "فنون إسلامية", "ترميم معماري (آثار مصرية)", "لغة أوربية حديثة - محادثة ومقال", "أعمال السنة (دراسات وبحوث)");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "himrThirdYearSecondSemester":
                setSubjectsName("تكنولوجيا المواد والصناعات القديمية (عضوية)", "علم الحفائر والمتاحف والتسجيل العملي", "لغة مصرية قديمة (1)", "علاج وصيانة الفخار والزجاج", "ترميم معماري آثار مصرية", "قراءات في ترميم الآثار بلغة أوربية حديثة", "أعمال السنة (دراسات وبحوث)");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.GONE);
                break;
            case "himrFourthYearFirstSemester":
                setSubjectsName("فحص الآثار وتحليلها وتاريخها", "علاج وصيانة المعادن", "تقنيات المنسوجات والسجاد", "لغة أوروبية حديثة - محادثة ومقال", "أعمال السنة (دراسات وبحوث)");
                sub6.setVisibility(View.GONE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
            case "himrFourthYearSecondSemester":
                setSubjectsName("علاج وصيانة المننسوجات", "حشرات وكائنات دقيقة", "صيانة وتشكيل معادن", "تصوير فوتوغرافي", "قراءة في ترميم الآثار بلغة أوربية حديثة", "أعمال السنة (دراسات وبحوث)");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.upload) {
            if (sitNum.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter the sit Number", Toast.LENGTH_LONG).show();
            } else if (name.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter a student Name", Toast.LENGTH_LONG).show();
            } else if (Long.parseLong(sitNum.getText().toString()) > 99999999) {
                Toast.makeText(this, "Invalid Number, please enter a correct number", Toast.LENGTH_LONG).show();
            } else if (sub1.getText().toString().isEmpty() || Integer.parseInt(sub1.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 1, please enter a correct number", Toast.LENGTH_LONG).show();
            } else if (sub2.getText().toString().isEmpty() || Integer.parseInt(sub2.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 2, please enter a correct number", Toast.LENGTH_LONG).show();
            } else if (sub3.getText().toString().isEmpty() || Integer.parseInt(sub3.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 3, please enter a correct number", Toast.LENGTH_LONG).show();
            } else if (sub4.getText().toString().isEmpty() || Integer.parseInt(sub4.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 4, please enter a correct number", Toast.LENGTH_LONG).show();
            } else if (sub5.getText().toString().isEmpty() || Integer.parseInt(sub5.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 5, please enter a correct number", Toast.LENGTH_LONG).show();
            } else if (sub6.getVisibility() == View.VISIBLE && sub6.getText().toString().isEmpty() ||
                    sub6.getVisibility() == View.VISIBLE && Integer.parseInt(sub6.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 6, please enter a correct number", Toast.LENGTH_LONG).show();
            } else if (sub7.getVisibility() == View.VISIBLE && sub7.getText().toString().isEmpty() ||
                    sub7.getVisibility() == View.VISIBLE && Integer.parseInt(sub7.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 7, please enter a correct number", Toast.LENGTH_LONG).show();
            }else if (sub8.getVisibility() == View.VISIBLE && sub8.getText().toString().isEmpty() ||
                    sub8.getVisibility() == View.VISIBLE && Integer.parseInt(sub8.getText().toString()) > 100) {
                Toast.makeText(this, "Invalid Score in Subject 7, please enter a correct number", Toast.LENGTH_LONG).show();
            } else {
                checkIntent();
                Intent intent = new Intent(this, StudentsList.class);
                intent.putExtra("intent", getIntent);
                startActivity(intent);
                finish();
            }
        }
    }

    public void checkIntent() {
        switchHicis();
        switchHith();
        switchHimr();
    }

    private void switchHicis() {
        switch (getIntent) {
            case "hicisFirstYearFirstSemester":
                setOnHicisFirstYearFirstSemester();
                break;
            case "hicisFirstYearSecondSemester":
                setOnHicisFirstYearSecondSemester();
                break;
            case "hicisSecondYearFirstSemester":
                setOnHicisSecondYearFirstSemester();
                break;
            case "hicisSecondYearSecondSemester":
                setOnHicisSecondYearSecondSemester();
                break;
            case "hicisThirdYearFirstSemester":
                setOnHicisThirdYearFirstSemester();
                break;
            case "hicisThirdYearSecondSemester":
                setOnHicisThirdYearSecondSemester();
                break;
            case "hicisFourthYearFirstSemester":
                setOnHicisFourthYearFirstSemester();
                break;
            case "hicisFourthYearSecondSemester":
                setOnHicisFourthYearSecondSemester();
                break;
        }
    }

    private void setOnHicisFirstYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);

        database.child("highInstituteForComputerAndInformationSystem")
                .child("firstYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHicisFirstYearSecondSemester() {
        sub7.setVisibility(View.GONE);
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);

        database.child("highInstituteForComputerAndInformationSystem")
                .child("firstYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHicisSecondYearFirstSemester() {
        if (division.isChecked()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()));
            pathSubjectNameToFirebase(5);
        } else if (!division.isChecked()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        }
        database.child("highInstituteForComputerAndInformationSystem")
                .child("secondYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHicisSecondYearSecondSemester() {
        if (division.isChecked()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        } else {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        }

        database.child("highInstituteForComputerAndInformationSystem")
                .child("secondYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHicisThirdYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("thirdYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHicisThirdYearSecondSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("thirdYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHicisFourthYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()));
        pathSubjectNameToFirebase(5);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("fourthYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHicisFourthYearSecondSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);
        database.child("highInstituteForComputerAndInformationSystem")
                .child("fourthYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private int onRadioButtonClick() {
        return radioGroup.getCheckedRadioButtonId();
    }

    private void switchHith() {
        switch (getIntent) {
            case "hithFirstYearFirstSemester":
                setOnHithFirstYearFirstSemester();
                break;
            case "hithFirstYearSecondSemester":
                setOnHithFirstYearSecondSemester();
                break;
            case "hithSecondYearFirstSemester":
                setOnHithSecondYearFirstSemester();
                break;
            case "hithSecondYearSecondSemester":
                setOnHithSecondYearSecondSemester();
                break;
            case "hithThirdYearFirstSemester":
                setOnHithThirdYearFirstSemester();
                break;
            case "hithThirdYearSecondSemester":
                setOnHithThirdYearSecondSemester();
                break;
            case "hithFourthYearFirstSemester":
                setOnHithFourthYearFirstSemester();
                break;
            case "hithFourthYearSecondSemester":
                setOnHithFourthYearSecondSemester();
                break;
        }
    }

    private void setOnHithFirstYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);
        database.child("highInstituteForTourismAndHotels")
                .child("firstYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHithFirstYearSecondSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);
        database.child("highInstituteForTourismAndHotels")
                .child("firstYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHithSecondYearFirstSemester() {
        if (R.id.tourism == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        } else if (R.id.hotels == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        } else if (R.id.tourism_guiding == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        }

        database.child("highInstituteForTourismAndHotels")
                .child("secondYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHithSecondYearSecondSemester() {
        if (R.id.tourism == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        } else if (R.id.hotels == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        } else if (R.id.tourism_guiding == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        }

        database.child("highInstituteForTourismAndHotels")
                .child("secondYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHithThirdYearFirstSemester() {
        if (R.id.tourism == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        } else if (R.id.hotels == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        } else if (R.id.tourism_guiding == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        }

        database.child("highInstituteForTourismAndHotels")
                .child("thirdYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHithThirdYearSecondSemester() {
        if (R.id.tourism == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        } else if (R.id.hotels == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        } else if (R.id.tourism_guiding == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        }

        database.child("highInstituteForTourismAndHotels")
                .child("thirdYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHithFourthYearFirstSemester() {
        if (R.id.tourism == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        } else if (R.id.hotels == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        } else if (R.id.tourism_guiding == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        }

        database.child("highInstituteForTourismAndHotels")
                .child("fourthYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHithFourthYearSecondSemester() {
        if (R.id.tourism == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        } else if (R.id.hotels == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
            pathSubjectNameToFirebase(6);
        } else if (R.id.tourism_guiding == onRadioButtonClick()) {
            student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                    Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                    Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                    Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                    Integer.parseInt(sub7.getText().toString()));
            pathSubjectNameToFirebase(7);
        }

        database.child("highInstituteForTourismAndHotels")
                .child("fourthYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void switchHimr() {
        switch (getIntent) {
            case "himrFirstYearFirstSemester":
                setOnHimrFirstYearFirstSemester();
                break;
            case "himrFirstYearSecondSemester":
                setOnHimrFirstYearSecondSemester();
                break;
            case "himrSecondYearFirstSemester":
                setOnHimrSecondYearFirstSemester();
                break;
            case "himrSecondYearSecondSemester":
                setOnHimrSecondYearSecondSemester();
                break;
            case "himrThirdYearFirstSemester":
                setOnHimrThirdYearFirstSemester();
                break;
            case "himrThirdYearSecondSemester":
                setOnHimrThirdYearSecondSemester();
                break;
            case "himrFourthYearFirstSemester":
                setOnHimrFourthYearFirstSemester();
                break;
            case "himrFourthYearSecondSemester":
                setOnHimrFourthYearSecondSemester();
                break;
        }
    }

    private void setOnHimrFirstYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                Integer.parseInt(sub7.getText().toString()));
        pathSubjectNameToFirebase(7);
        database.child("highInstituteForMonumentRestoration")
                .child("firstYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHimrFirstYearSecondSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                Integer.parseInt(sub7.getText().toString()));
        pathSubjectNameToFirebase(7);
        database.child("highInstituteForMonumentRestoration")
                .child("firstYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHimrSecondYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                Integer.parseInt(sub7.getText().toString()), Integer.parseInt(sub8.getText().toString()));
        pathSubjectNameToFirebase(8);
        database.child("highInstituteForMonumentRestoration")
                .child("secondYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHimrSecondYearSecondSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                Integer.parseInt(sub7.getText().toString()), Integer.parseInt(sub8.getText().toString()));
        pathSubjectNameToFirebase(8);
        database.child("highInstituteForMonumentRestoration")
                .child("secondYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHimrThirdYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);
        database.child("highInstituteForMonumentRestoration")
                .child("thirdYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHimrThirdYearSecondSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()),
                Integer.parseInt(sub7.getText().toString()));
        pathSubjectNameToFirebase(7);
        database.child("highInstituteForMonumentRestoration")
                .child("thirdYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHimrFourthYearFirstSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()));
        pathSubjectNameToFirebase(5);
        database.child("highInstituteForMonumentRestoration")
                .child("fourthYear").child("firstSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void setOnHimrFourthYearSecondSemester() {
        student = new Student(name.getText().toString(), Integer.parseInt(sitNum.getText().toString()),
                Integer.parseInt(sub1.getText().toString()), Integer.parseInt(sub2.getText().toString()),
                Integer.parseInt(sub3.getText().toString()), Integer.parseInt(sub4.getText().toString()),
                Integer.parseInt(sub5.getText().toString()), Integer.parseInt(sub6.getText().toString()));
        pathSubjectNameToFirebase(6);
        database.child("highInstituteForMonumentRestoration")
                .child("fourthYear").child("secondSemester").child(sitNum.getText().toString())
                .setValue(student);
        ifSuccessfullyInserted();
    }

    private void ifSuccessfullyInserted() {
        Toast.makeText(this, "Successfully inserted", Toast.LENGTH_LONG).show();
    }

    private void setSubjectsName(String subName1, String subName2, String subName3, String subName4, String subName5) {
        this.subName1 = subName1;
        sub1.setHint(subName1);
        this.subName2 = subName2;
        sub2.setHint(subName2);
        this.subName3 = subName3;
        sub3.setHint(subName3);
        this.subName4 = subName4;
        sub4.setHint(subName4);
        this.subName5 = subName5;
        sub5.setHint(subName5);
    }

    private void setSubjectsName(String subName1, String subName2, String subName3, String subName4, String subName5, String subName6) {
        this.subName1 = subName1;
        sub1.setHint(subName1);
        this.subName2 = subName2;
        sub2.setHint(subName2);
        this.subName3 = subName3;
        sub3.setHint(subName3);
        this.subName4 = subName4;
        sub4.setHint(subName4);
        this.subName5 = subName5;
        sub5.setHint(subName5);
        this.subName6 = subName6;
        sub6.setHint(subName6);
    }

    private void setSubjectsName(String subName1, String subName2, String subName3, String subName4, String subName5, String subName6,
                                 String subName7) {
        this.subName1 = subName1;
        sub1.setHint(subName1);
        this.subName2 = subName2;
        sub2.setHint(subName2);
        this.subName3 = subName3;
        sub3.setHint(subName3);
        this.subName4 = subName4;
        sub4.setHint(subName4);
        this.subName5 = subName5;
        sub5.setHint(subName5);
        this.subName6 = subName6;
        sub6.setHint(subName6);
        this.subName7 = subName7;
        sub7.setHint(subName7);
    }

    private void setSubjectsName(String subName1, String subName2, String subName3, String subName4, String subName5, String subName6,
                                 String subName7, String subName8) {
        this.subName1 = subName1;
        sub1.setHint(subName1);
        this.subName2 = subName2;
        sub2.setHint(subName2);
        this.subName3 = subName3;
        sub3.setHint(subName3);
        this.subName4 = subName4;
        sub4.setHint(subName4);
        this.subName5 = subName5;
        sub5.setHint(subName5);
        this.subName6 = subName6;
        sub6.setHint(subName6);
        this.subName7 = subName7;
        sub7.setHint(subName7);
        this.subName8 = subName8;
        sub8.setHint(subName8);
    }

    private void pathSubjectNameToFirebase(int numberOfSubject) {
        if (numberOfSubject == 5) {
            student.setSubName1(subName1);
            student.setSubName2(subName2);
            student.setSubName3(subName3);
            student.setSubName4(subName4);
            student.setSubName5(subName5);
        } else if (numberOfSubject == 6) {
            student.setSubName1(subName1);
            student.setSubName2(subName2);
            student.setSubName3(subName3);
            student.setSubName4(subName4);
            student.setSubName5(subName5);
            student.setSubName6(subName6);
        } else if (numberOfSubject == 7) {
            student.setSubName1(subName1);
            student.setSubName2(subName2);
            student.setSubName3(subName3);
            student.setSubName4(subName4);
            student.setSubName5(subName5);
            student.setSubName6(subName6);
            student.setSubName7(subName7);
        }
    }
}
