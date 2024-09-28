package com.example.backend.repository;

import com.example.backend.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {
    List<List> findByBoardId(Long boardId);
}
