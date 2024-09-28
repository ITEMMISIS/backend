package com.example.backend.exception;

public class TagNotFoundException extends ResourceNotFoundException {
    public TagNotFoundException(Long id) {
        super("Tag not found with ID: " + id);
    }
}
