package com.comp2154.student_system.dto;
import jakarta.validation.constraints.*;
public class GradeRequest {
 @NotNull(message="Student ID is required") private Integer studentId;
 @NotNull(message="Course ID is required") private Long courseId;
 @NotNull(message="Score is required") @Min(value=0,message="Score cannot be negative") @Max(value=100,message="Score cannot exceed 100") private Integer score;
 public Integer getStudentId(){return studentId;} public void setStudentId(Integer v){studentId=v;} public Long getCourseId(){return courseId;} public void setCourseId(Long v){courseId=v;} public Integer getScore(){return score;} public void setScore(Integer v){score=v;}
}
