package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByListId(Long listId);
}
