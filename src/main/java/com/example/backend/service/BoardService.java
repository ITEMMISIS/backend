package com.example.backend.service;

import com.example.backend.exception.BoardNotFoundException;
import com.example.backend.model.Board;
import com.example.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // Получение всех досок
    public List<Board> getAllBoards(String token) {
        // Валидация токена (обработка пользователя)
        return boardRepository.findAll();
    }

    // Создание новой доски
    public Board createBoard(String token, Board board) {
        // Валидация и сохранение доски
        return boardRepository.save(board);
    }

    // Удаление доски
    public ResponseEntity<Void> deleteBoard(Long boardId, String token) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException("Board not found"));
        boardRepository.delete(board);
        return ResponseEntity.ok().build();
    }
}
