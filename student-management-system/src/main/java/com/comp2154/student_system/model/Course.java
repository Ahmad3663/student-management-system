package com.comp2154.student_system.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity @Table(name="courses")
public class Course {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank(message="Course code is required") @Column(nullable=false, unique=true) private String code;
 @NotBlank(message="Course title is required") @Column(nullable=false) private String title;
 @NotBlank(message="Instructor name is required") @Column(nullable=false) private String instructorName;
 public Course() {}
 public Course(String code,String title,String instructorName){this.code=code;this.title=title;this.instructorName=instructorName;}
 public Long getId(){return id;} public String getCode(){return code;} public void setCode(String v){code=v;} public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getInstructorName(){return instructorName;} public void setInstructorName(String v){instructorName=v;}
}
