package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    // Здесь могут быть дополнительные методы, если нужно
}
