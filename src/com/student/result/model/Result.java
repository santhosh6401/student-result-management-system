package com.student.result.model;

import java.util.ArrayList;

public class Result {
    @Override
    public String toString() {
        return "List of Student Result \r\n" + studentList;
    }

    private ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
