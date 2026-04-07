package com.comp2154.student_system.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity @Table(name="grades")
public class Grade {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private Integer studentId;
 @ManyToOne(optional=false) private Course course;
 @NotNull @Min(value=0,message="Score cannot be negative") @Max(value=100,message="Score cannot exceed 100") @Column(nullable=false) private Integer score;
 @Column(nullable=false) private String letterGrade;
 public Grade() {}
 public Grade(Integer studentId, Course course, Integer score, String letterGrade){this.studentId=studentId;this.course=course;this.score=score;this.letterGrade=letterGrade;}
 public Long getId(){return id;} public Integer getStudentId(){return studentId;} public void setStudentId(Integer v){studentId=v;} public Course getCourse(){return course;} public void setCourse(Course v){course=v;} public Integer getScore(){return score;} public void setScore(Integer v){score=v;} public String getLetterGrade(){return letterGrade;} public void setLetterGrade(String v){letterGrade=v;}
}
