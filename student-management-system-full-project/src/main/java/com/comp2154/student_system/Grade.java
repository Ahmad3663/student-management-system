package com.comp2154.student_system;

public class Grade {

    private int id;
    private int enrollmentId;
    private String gradeValue;
    private String remarks;

    public Grade() {
    }

    public Grade(int id, int enrollmentId, String gradeValue, String remarks) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.gradeValue = gradeValue;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
