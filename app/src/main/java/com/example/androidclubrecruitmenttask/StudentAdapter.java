package com.example.androidclubrecruitmenttask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.CricketerView> {

    ArrayList<Student> cricketersList = new ArrayList<>();

    public StudentAdapter(ArrayList<Student> cricketersList) {
        this.cricketersList = cricketersList;
    }

    @NonNull
    @Override
    public CricketerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_student, parent, false);
        return new CricketerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketerView holder, int position) {

        Student cricketer = cricketersList.get(position);
        holder.textCricketerName.setText(cricketer.getStudentName());
        holder.textTeamName.setText(cricketer.getBranchName());
    }

    @Override
    public int getItemCount() {
        return cricketersList.size();
    }

    public static class CricketerView extends RecyclerView.ViewHolder {

        TextView textCricketerName, textTeamName;
        public CricketerView(@NonNull View itemView) {
            super(itemView);
            textCricketerName = (TextView) itemView.findViewById(R.id.text_student_name);
            textTeamName = (TextView) itemView.findViewById(R.id.text_branch_name);
        }
    }
}
