package com.example.backend.controller;

import com.example.backend.model.Board;
import com.example.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(boardService.getAllBoards(token));
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestHeader("Authorization") String token, @RequestBody Board board) {
        return ResponseEntity.status(201).body(boardService.createBoard(token, board));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId, @RequestHeader("Authorization") String token) {
        return boardService.deleteBoard(boardId, token);
    }
}
