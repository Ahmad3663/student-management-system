package com.comp2154.student_system.service;

import com.comp2154.student_system.dto.LoginRequest;
import com.comp2154.student_system.dto.LoginResponse;
import com.comp2154.student_system.dto.SignupRequest;
import com.comp2154.student_system.model.AppUser;
import com.comp2154.student_system.model.Student;
import com.comp2154.student_system.model.UserRole;
import com.comp2154.student_system.repository.StudentRepository;
import com.comp2154.student_system.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public AuthService(UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    public LoginResponse login(LoginRequest req) {
        AppUser user = userRepository.findByUsername(req.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        if (!user.getPassword().equals(req.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return new LoginResponse(true, "Login successful", user.getUsername(), user.getRole().name(), user.getLinkedStudentId());
    }

    public LoginResponse signup(SignupRequest req) {
        userRepository.findByUsername(req.getUsername()).ifPresent(existing -> {
            throw new IllegalArgumentException("Username already exists");
        });

        UserRole role;
        try {
            role = UserRole.valueOf(req.getRole().trim().toUpperCase());
        } catch (Exception ex) {
            throw new IllegalArgumentException("Role must be ADMIN, INSTRUCTOR, or STUDENT");
        }

        Integer linkedStudentId = null;
        if (role == UserRole.STUDENT) {
            if (req.getStudentId() == null || req.getStudentId() <= 0) {
                throw new IllegalArgumentException("Student ID is required for student accounts");
            }
            if (req.getFullName() == null || req.getFullName().trim().isEmpty()) {
                throw new IllegalArgumentException("Full name is required for student accounts");
            }
            if (req.getEmail() == null || req.getEmail().trim().isEmpty()) {
                throw new IllegalArgumentException("Email is required for student accounts");
            }
            if (studentRepository.existsById(req.getStudentId())) {
                throw new IllegalArgumentException("Student ID already exists");
            }
            studentRepository.findByEmail(req.getEmail().trim()).ifPresent(existing -> {
                throw new IllegalArgumentException("Email already exists");
            });

            Student student = new Student(req.getStudentId(), req.getFullName().trim(), req.getEmail().trim());
            studentRepository.save(student);
            linkedStudentId = req.getStudentId();
        }

        AppUser user = new AppUser(req.getUsername().trim(), req.getPassword(), role, linkedStudentId);
        userRepository.save(user);

        return new LoginResponse(true, "Account created successfully", user.getUsername(), user.getRole().name(), user.getLinkedStudentId());
    }
}
