package com.comp2154.student_system.repository;
import com.comp2154.student_system.model.Grade; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface GradeRepository extends JpaRepository<Grade,Long>{ List<Grade> findByStudentId(Integer studentId); }
