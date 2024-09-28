package com.example.backend.service;

import com.example.backend.dto.InviteRequestDto;
import com.example.backend.exception.BoardNotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborationService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    // Генерация ссылки приглашения
    public String generateInviteLink(Long boardId, String token, InviteRequestDto inviteRequest) {
        // Логика для создания ссылки приглашения
        return "invite-link"; // вернуть реальную ссылку
    }

    // Принятие приглашения
    public ResponseEntity<Void> acceptInvite(String inviteToken, String token) {
        // Логика для принятия приглашения
        return ResponseEntity.ok().build();
    }

    // Получение пользователей доски
    public List<User> getBoardUsers(Long boardId, String token) {
        boardRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("Board not found"));
        return userRepository.findByBoardId(boardId);
    }
}
