package com.example.backend.controller;

import com.example.backend.dto.InviteRequestDto;
import com.example.backend.model.User;
import com.example.backend.service.CollaborationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards/{boardId}/invite")
public class CollaborationController {
    
    @Autowired
    private CollaborationService collaborationService;

    @PostMapping
    public ResponseEntity<String> generateInviteLink(@PathVariable Long boardId, @RequestHeader("Authorization") String token, @RequestBody InviteRequestDto inviteRequest) {
        return ResponseEntity.ok(collaborationService.generateInviteLink(boardId, token, inviteRequest));
    }

    @PostMapping("/accept/{inviteToken}")
    public ResponseEntity<Void> acceptInvite(@PathVariable String inviteToken, @RequestHeader("Authorization") String token) {
        return collaborationService.acceptInvite(inviteToken, token);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getBoardUsers(@PathVariable Long boardId, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(collaborationService.getBoardUsers(boardId, token));
    }
}
