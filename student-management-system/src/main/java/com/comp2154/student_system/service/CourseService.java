package com.comp2154.student_system.service;
import com.comp2154.student_system.model.Course; import com.comp2154.student_system.repository.CourseRepository; import java.util.List; import org.springframework.stereotype.Service;
@Service public class CourseService {
 private final CourseRepository repo; public CourseService(CourseRepository repo){this.repo=repo;}
 public List<Course> getAllCourses(){return repo.findAll();}
 public Course getCourseById(Long id){return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Course with id "+id+" not found"));}
 public Course createCourse(Course c){ repo.findByCode(c.getCode()).ifPresent(x->{throw new IllegalArgumentException("Course code already exists");}); return repo.save(c);} 
 public Course updateCourse(Long id, Course c){ Course existing=getCourseById(id); repo.findByCode(c.getCode()).ifPresent(other->{ if(!other.getId().equals(id)) throw new IllegalArgumentException("Course code already exists");}); existing.setCode(c.getCode()); existing.setTitle(c.getTitle()); existing.setInstructorName(c.getInstructorName()); return repo.save(existing);} 
 public void deleteCourse(Long id){ repo.delete(getCourseById(id)); }
}
