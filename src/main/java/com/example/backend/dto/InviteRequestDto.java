package com.example.backend.dto;

public class InviteRequestDto {
    private Long boardId;
    private String email;

    // Геттеры и сеттеры
    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
