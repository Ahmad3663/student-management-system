package com.comp2154.student_system.service;
import com.comp2154.student_system.dto.*; import com.comp2154.student_system.model.*; import com.comp2154.student_system.repository.GradeRepository; import java.util.List; import java.util.stream.Collectors; import org.springframework.stereotype.Service;
@Service public class GradeService {
 private final GradeRepository repo; private final StudentService studentService; private final CourseService courseService;
 public GradeService(GradeRepository repo, StudentService studentService, CourseService courseService){this.repo=repo;this.studentService=studentService;this.courseService=courseService;}
 public List<GradeView> getAllGrades(){ return repo.findAll().stream().map(this::toView).collect(Collectors.toList()); }
 public List<GradeView> getGradesForStudent(Integer studentId){ return repo.findByStudentId(studentId).stream().map(this::toView).collect(Collectors.toList()); }
 public GradeView createGrade(GradeRequest req){ Student s=studentService.getStudentById(req.getStudentId()); Course c=courseService.getCourseById(req.getCourseId()); Grade g=new Grade(s.getId(),c,req.getScore(),toLetter(req.getScore())); return toView(repo.save(g)); }
 public GradeView updateGrade(Long id, GradeRequest req){ Grade g=repo.findById(id).orElseThrow(()->new IllegalArgumentException("Grade with id "+id+" not found")); Student s=studentService.getStudentById(req.getStudentId()); Course c=courseService.getCourseById(req.getCourseId()); g.setStudentId(s.getId()); g.setCourse(c); g.setScore(req.getScore()); g.setLetterGrade(toLetter(req.getScore())); return toView(repo.save(g)); }
 public void deleteGrade(Long id){ Grade g=repo.findById(id).orElseThrow(()->new IllegalArgumentException("Grade with id "+id+" not found")); repo.delete(g); }
 private GradeView toView(Grade g){ Student s=studentService.getStudentById(g.getStudentId()); Course c=g.getCourse(); return new GradeView(g.getId(), g.getStudentId(), s.getName(), c.getId(), c.getCode(), c.getTitle(), g.getScore(), g.getLetterGrade()); }
 private String toLetter(Integer score){ if(score>=90) return "A+"; if(score>=85) return "A"; if(score>=80) return "A-"; if(score>=77) return "B+"; if(score>=73) return "B"; if(score>=70) return "B-"; if(score>=67) return "C+"; if(score>=63) return "C"; if(score>=60) return "C-"; if(score>=50) return "D"; return "F"; }
}
