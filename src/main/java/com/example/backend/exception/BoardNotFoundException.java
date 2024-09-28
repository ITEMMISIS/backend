package com.example.backend.exception;

public class BoardNotFoundException extends ResourceNotFoundException {
    public BoardNotFoundException(Long id) {
        super("Board not found with ID: " + id);
    }
}
