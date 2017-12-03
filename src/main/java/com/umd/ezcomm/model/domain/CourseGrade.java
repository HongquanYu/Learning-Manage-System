package com.umd.ezcomm.model.domain;
public class CourseGrade {

    private String StudentID;
    private String StudentName;
    private String CourseID;
    private int CourseGrade;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public int getCourseGrade() {
        return CourseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        CourseGrade = courseGrade;
    }

}

