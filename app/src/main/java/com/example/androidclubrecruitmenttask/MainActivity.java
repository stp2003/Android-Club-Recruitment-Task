package com.example.androidclubrecruitmenttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutList;
    Button buttonAdd;
    Button buttonSubmitList;

    List<String> teamList = new ArrayList<>();
    ArrayList<Student> studentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Objects.requireNonNull(getSupportActionBar()).setTitle("Dynamic Recycler View");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);
        buttonSubmitList = findViewById(R.id.button_submit_list);

        buttonAdd.setOnClickListener(this);
        buttonSubmitList.setOnClickListener(this);


        teamList.add("Branch");
        teamList.add(" ");
        teamList.add("BCE");
        teamList.add("BSA");
        teamList.add("BYC");
        teamList.add("ECE");
        teamList.add("MIM");
        teamList.add(" ");

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                addView();
                break;

            case R.id.button_submit_list:
                if (checkIfValidAndRead()) {
                    Intent intent = new Intent(MainActivity.this, ActivityStudents.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", studentsList);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
        }
    }

    private boolean checkIfValidAndRead() {
        studentsList.clear();
        boolean result = true;
        for (int i = 0; i < layoutList.getChildCount(); i++) {
            View cricketerView = layoutList.getChildAt(i);

            EditText editTextName = (EditText) cricketerView.findViewById(R.id.edit_student_name);
            AppCompatSpinner studentDropDown = (AppCompatSpinner) cricketerView.findViewById(R.id.spinner_branch);

            Student student = new Student();

            if (!editTextName.getText().toString().equals("")) {
                student.setStudentName(editTextName.getText().toString());
            } else {
                result = false;
                break;
            }

            if (studentDropDown.getSelectedItemPosition() != 0) {
                student.setBranchName(teamList.get(studentDropDown.getSelectedItemPosition()));
            } else {
                result = false;
                break;
            }

            studentsList.add(student);
        }

        if (studentsList.size() == 0) {
            result = false;
            Toast.makeText(this, "Add Cricketers First!", Toast.LENGTH_SHORT).show();
        } else if (!result) {
            Toast.makeText(this, "Enter All Details Correctly!", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    private void addView() {

        @SuppressLint("InflateParams") final View studentView = getLayoutInflater().inflate(R.layout.row_add_student, null, false);

        EditText editText = (EditText) studentView.findViewById(R.id.edit_student_name);
        AppCompatSpinner spinnerTeam = (AppCompatSpinner) studentView.findViewById(R.id.spinner_branch);
        ImageView imageClose = (ImageView) studentView.findViewById(R.id.image_delete);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, teamList);
        spinnerTeam.setAdapter(arrayAdapter);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(studentView);
            }
        });

        layoutList.addView(studentView);
    }

    private void removeView(View view) {
        layoutList.removeView(view);
    }
}
