package com.example.backend.controller;

import com.example.backend.model.List;
import com.example.backend.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards/{boardId}/lists")
public class ListController {
    
    @Autowired
    private ListService listService;

    @GetMapping
    public ResponseEntity<java.util.List<List>> getAllLists(@PathVariable Long boardId, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(listService.getAllLists(boardId, token));
    }

    @PostMapping
    public ResponseEntity<List> createList(@PathVariable Long boardId, @RequestHeader("Authorization") String token, @RequestBody List list) {
        return ResponseEntity.status(201).body(listService.createList(boardId, token, list));
    }

    @DeleteMapping("/{listId}")
    public ResponseEntity<Void> deleteList(@PathVariable Long boardId, @PathVariable Long listId, @RequestHeader("Authorization") String token) {
        return listService.deleteList(boardId, listId, token);
    }
}
