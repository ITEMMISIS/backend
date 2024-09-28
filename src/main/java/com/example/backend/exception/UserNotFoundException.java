package com.example.backend.exception;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(Long id) {
        super("User not found with ID: " + id);
    }
}
