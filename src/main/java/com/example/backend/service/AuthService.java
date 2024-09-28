package com.example.backend.service;

import com.example.backend.dto.LoginDto;
import com.example.backend.dto.UserRegistrationDto;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Метод регистрации пользователя
    public ResponseEntity<?> registerUser(UserRegistrationDto registrationDto) {
        // Валидация и создание пользователя
        User user = new User(registrationDto.getUsername(), registrationDto.getEmail(), registrationDto.getPassword());
        userRepository.save(user);
        return ResponseEntity.status(201).body(user);
    }

    // Метод входа пользователя
    public ResponseEntity<?> loginUser(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user == null || !user.getPasswordHash().equals(loginDto.getPassword())) {
            throw new javax.naming.AuthenticationException("Invalid email or password");
        }
        String jwtToken = generateJwtToken(user); // Генерация JWT токена
        return ResponseEntity.ok(Collections.singletonMap("token", jwtToken));
    }

    private String generateJwtToken(User user) {
        // Логика генерации JWT
        return "fake-jwt-token"; // заменить на реальную реализацию
    }
}
