package com.example.backend.exception;

public class InviteRequestNotFoundException extends ResourceNotFoundException {
    public InviteRequestNotFoundException(Long id) {
        super("Invite Request not found with ID: " + id);
    }
}
