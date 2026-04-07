package com.comp2154.student_system.dto;
public class GradeView {
 private Long id; private Integer studentId; private String studentName; private Long courseId; private String courseCode; private String courseTitle; private Integer score; private String letterGrade;
 public GradeView(Long id,Integer studentId,String studentName,Long courseId,String courseCode,String courseTitle,Integer score,String letterGrade){this.id=id;this.studentId=studentId;this.studentName=studentName;this.courseId=courseId;this.courseCode=courseCode;this.courseTitle=courseTitle;this.score=score;this.letterGrade=letterGrade;}
 public Long getId(){return id;} public Integer getStudentId(){return studentId;} public String getStudentName(){return studentName;} public Long getCourseId(){return courseId;} public String getCourseCode(){return courseCode;} public String getCourseTitle(){return courseTitle;} public Integer getScore(){return score;} public String getLetterGrade(){return letterGrade;}
}
