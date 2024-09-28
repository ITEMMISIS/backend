package com.example.backend.exception;

public class ListNotFoundException extends ResourceNotFoundException {
    public ListNotFoundException(Long id) {
        super("List not found with ID: " + id);
    }
}
