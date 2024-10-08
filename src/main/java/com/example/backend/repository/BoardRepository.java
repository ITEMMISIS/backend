package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByUserId(Long userId);
}
