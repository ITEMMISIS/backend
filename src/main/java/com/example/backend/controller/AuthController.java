package com.example.backend.controller;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.UserRegistrationDto;
import com.example.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationDto registrationDto) {
        return authService.registerUser(registrationDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return authService.loginUser(loginDto);
    }
}
