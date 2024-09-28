package com.example.backend.repository;

import com.example.backend.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InviteRequestRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findByBoardId(Long boardId);
}
