package com.comp2154.student_system.model;
import jakarta.persistence.*;
@Entity @Table(name="app_users")
public class AppUser {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false, unique=true) private String username;
  @Column(nullable=false) private String password;
  @Enumerated(EnumType.STRING) @Column(nullable=false) private UserRole role;
  private Integer linkedStudentId;
  public AppUser() {}
  public AppUser(String username, String password, UserRole role, Integer linkedStudentId) { this.username=username; this.password=password; this.role=role; this.linkedStudentId=linkedStudentId; }
  public Long getId(){return id;} public String getUsername(){return username;} public void setUsername(String v){username=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public UserRole getRole(){return role;} public void setRole(UserRole v){role=v;} public Integer getLinkedStudentId(){return linkedStudentId;} public void setLinkedStudentId(Integer v){linkedStudentId=v;}
}
