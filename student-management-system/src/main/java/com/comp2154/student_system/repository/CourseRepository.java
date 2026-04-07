package com.comp2154.student_system.repository;
import com.comp2154.student_system.model.Course; import java.util.Optional; import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<Course,Long>{ Optional<Course> findByCode(String code); }
