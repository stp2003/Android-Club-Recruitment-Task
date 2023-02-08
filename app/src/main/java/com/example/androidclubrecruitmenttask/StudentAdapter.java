package com.example.androidclubrecruitmenttask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.studentsView> {

    ArrayList<Student> studentList = new ArrayList<>();

    public StudentAdapter(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public studentsView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_student, parent, false);
        return new studentsView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull studentsView holder, int position) {

        Student student = studentList.get(position);
        holder.textStudentName.setText(student.getStudentName());
        holder.textBranchName.setText(student.getBranchName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class studentsView extends RecyclerView.ViewHolder {

        TextView textStudentName, textBranchName;

        public studentsView(@NonNull View itemView) {
            super(itemView);
            textStudentName = (TextView) itemView.findViewById(R.id.text_student_name);
            textBranchName = (TextView) itemView.findViewById(R.id.text_branch_name);
        }
    }
}
