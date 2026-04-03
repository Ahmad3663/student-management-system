package com.comp2154.student_system;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Ahmad", "ahmad@email.com"));
        students.add(new Student(2, "Ali", "ali@email.com"));
    }

    // READ (GET all)
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setEmail(updatedStudent.getEmail());
                return s;
            }
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(s -> s.getId() == id);
        return "Deleted";
    }
}
