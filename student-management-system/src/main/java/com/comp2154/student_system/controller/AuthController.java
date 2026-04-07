package com.comp2154.student_system.controller;

import com.comp2154.student_system.dto.LoginRequest;
import com.comp2154.student_system.dto.LoginResponse;
import com.comp2154.student_system.dto.SignupRequest;
import com.comp2154.student_system.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        return service.login(req);
    }

    @PostMapping("/signup")
    public LoginResponse signup(@Valid @RequestBody SignupRequest req) {
        return service.signup(req);
    }
}
