package com.student.result.model;

import java.util.Map;


public class Student {

    private String rollNo;
    private String studentName;
    private Map<String, Integer> subjectAndScore;
    private double averageScore;
    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String displayDetails() {
        return "Roll Number       :: " + rollNo + "\n" +
                "Student Name      :: " + studentName + "\n" +
                "Subject And Score :: " + subjectAndScore + "\n" +
                "Average Score     :: " + averageScore + "\n" +
                "Result            :: " + result + "\n" +
                "Total             :: " + totalScore;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Map<String, Integer> getSubjectAndScore() {
        return subjectAndScore;
    }

    public void setSubjectAndScore(Map<String, Integer> subjectAndScore) {
        this.subjectAndScore = subjectAndScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;
}
