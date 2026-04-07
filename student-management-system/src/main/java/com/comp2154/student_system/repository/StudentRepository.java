package com.comp2154.student_system.repository;
import com.comp2154.student_system.model.Student; import java.util.Optional; import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student,Integer>{ Optional<Student> findByEmail(String email); }
