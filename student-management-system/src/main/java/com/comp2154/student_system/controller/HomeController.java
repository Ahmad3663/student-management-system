package com.comp2154.student_system.controller;
import java.util.Map; import org.springframework.web.bind.annotation.*;
@RestController public class HomeController { @GetMapping("/api/health") public Map<String,String> health(){ return Map.of("status","UP","message","Student Management System is running"); } }
