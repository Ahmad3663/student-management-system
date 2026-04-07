package com.comp2154.student_system.service;
import com.comp2154.student_system.model.Student; import com.comp2154.student_system.repository.StudentRepository; import java.util.List; import org.springframework.stereotype.Service;
@Service public class StudentService {
 private final StudentRepository repo; public StudentService(StudentRepository repo){this.repo=repo;}
 public List<Student> getAllStudents(){return repo.findAll();}
 public Student getStudentById(Integer id){return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Student with id "+id+" not found"));}
 public Student createStudent(Student s){ if(repo.existsById(s.getId())) throw new IllegalArgumentException("Student ID already exists"); repo.findByEmail(s.getEmail()).ifPresent(e->{throw new IllegalArgumentException("Email already exists");}); return repo.save(s);} 
 public Student updateStudent(Integer id, Student s){ Student existing=getStudentById(id); if(!id.equals(s.getId())) throw new IllegalArgumentException("Student ID cannot be changed"); repo.findByEmail(s.getEmail()).ifPresent(other->{ if(!other.getId().equals(id)) throw new IllegalArgumentException("Email already exists");}); existing.setName(s.getName()); existing.setEmail(s.getEmail()); return repo.save(existing);} 
 public void deleteStudent(Integer id){ repo.delete(getStudentById(id)); }
}
