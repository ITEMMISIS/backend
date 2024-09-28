package com.example.backend.exception;

public class CardNotFoundException extends ResourceNotFoundException {
    public CardNotFoundException(Long id) {
        super("Card not found with ID: " + id);
    }
}
