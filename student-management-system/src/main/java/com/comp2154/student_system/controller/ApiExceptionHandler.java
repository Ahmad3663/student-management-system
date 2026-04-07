package com.comp2154.student_system.controller;
import java.util.*; import java.util.stream.Collectors; import org.springframework.http.ResponseEntity; import org.springframework.validation.FieldError; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(IllegalArgumentException.class)
 public ResponseEntity<Map<String,String>> handleIllegalArgument(IllegalArgumentException ex){ return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage())); }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException ex){ String errors=ex.getBindingResult().getAllErrors().stream().map(error-> error instanceof FieldError fe ? fe.getField()+": "+fe.getDefaultMessage() : error.getDefaultMessage()).collect(Collectors.joining(", ")); return ResponseEntity.badRequest().body(Map.of("error", errors)); }
}
