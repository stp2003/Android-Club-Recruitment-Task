package com.example.androidclubrecruitmenttask;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityStudents extends AppCompatActivity {

    RecyclerView recyclerCricketers;
    ArrayList<Student> cricketersList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        recyclerCricketers = findViewById(R.id.recycler_students);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerCricketers.setLayoutManager(layoutManager);

        cricketersList = (ArrayList<Student>) getIntent().getExtras().getSerializable("list");

        recyclerCricketers.setAdapter(new StudentAdapter(cricketersList));

    }
}
