package com.example.backend.service;

import com.example.backend.exception.CardNotFoundException;
import com.example.backend.exception.ListNotFoundException;
import com.example.backend.model.Card;
import com.example.backend.repository.CardRepository;
import com.example.backend.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ListRepository listRepository;

    // Получение всех карточек в списке
    public List<Card> getAllCards(Long listId, String token) {
        listRepository.findById(listId).orElseThrow(() -> new ListNotFoundException("List not found"));
        return cardRepository.findByListId(listId);
    }

    // Создание карточки
    public Card createCard(Long listId, String token, Card card) {
        card.setListId(listId);
        return cardRepository.save(card);
    }

    // Обновление карточки
    public Card updateCard(Long cardId, String token, Card cardDetails) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CardNotFoundException("Card not found"));
        card.updateDetails(cardDetails); // Метод для обновления полей карточки
        return cardRepository.save(card);
    }

    // Удаление карточки
    public ResponseEntity<Void> deleteCard(Long cardId, String token) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CardNotFoundException("Card not found"));
        cardRepository.delete(card);
        return ResponseEntity.ok().build();
    }
}
