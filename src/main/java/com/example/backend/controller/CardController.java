package com.example.backend.controller;

import com.example.backend.model.Card;
import com.example.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lists/{listId}/cards")
public class CardController {
    
    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(@PathVariable Long listId, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(cardService.getAllCards(listId, token));
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@PathVariable Long listId, @RequestHeader("Authorization") String token, @RequestBody Card card) {
        return ResponseEntity.status(201).body(cardService.createCard(listId, token, card));
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestHeader("Authorization") String token, @RequestBody Card cardDetails) {
        return ResponseEntity.ok(cardService.updateCard(cardId, token, cardDetails));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId, @RequestHeader("Authorization") String token) {
        return cardService.deleteCard(cardId, token);
    }
}
