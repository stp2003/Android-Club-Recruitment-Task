package com.example.androidclubrecruitmenttask;
import java.io.Serializable;

public class Student implements Serializable {

    public String studentName;
    public String branchName;

    public Student() {

    }

    public Student(String studentName, String branchName) {
        this.studentName = studentName;
        this.branchName = branchName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

}
