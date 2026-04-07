package com.comp2154.student_system.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity @Table(name="students")
public class Student {
 @Id @Min(value=1,message="Student ID must be greater than 0") private Integer id;
 @NotBlank(message="Name is required") @Column(nullable=false) private String name;
 @NotBlank(message="Email is required") @Email(message="Email format is invalid") @Column(nullable=false, unique=true) private String email;
 public Student() {}
 public Student(Integer id,String name,String email){this.id=id;this.name=name;this.email=email;}
 public Integer getId(){return id;} public void setId(Integer v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
}
