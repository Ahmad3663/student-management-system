package com.comp2154.student_system;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        return Arrays.asList(
            new Student(1, "Ahmad Ashoor", "ahmad@example.com"),
            new Student(2, "Sample Student", "student@example.com")
        );
    }
}
