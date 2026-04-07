package com.comp2154.student_system.dto;
public class LoginResponse {
 private boolean success; private String message; private String username; private String role; private Integer linkedStudentId;
 public LoginResponse(boolean success,String message,String username,String role,Integer linkedStudentId){this.success=success;this.message=message;this.username=username;this.role=role;this.linkedStudentId=linkedStudentId;}
 public boolean isSuccess(){return success;} public String getMessage(){return message;} public String getUsername(){return username;} public String getRole(){return role;} public Integer getLinkedStudentId(){return linkedStudentId;}
}
