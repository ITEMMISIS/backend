package com.example.backend.service;

import com.example.backend.exception.BoardNotFoundException;
import com.example.backend.exception.ListNotFoundException;
import com.example.backend.model.List;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;
    
    @Autowired
    private BoardRepository boardRepository;

    // Получение всех списков на доске
    public List<List> getAllLists(Long boardId, String token) {
        boardRepository.findById(boardId).orElseThrow(() -> new BoardNotFoundException("Board not found"));
        return listRepository.findByBoardId(boardId);
    }

    // Создание списка
    public List createList(Long boardId, String token, List list) {
        // Валидация и сохранение списка
        list.setBoardId(boardId);
        return listRepository.save(list);
    }

    // Удаление списка
    public ResponseEntity<Void> deleteList(Long boardId, Long listId, String token) {
        List list = listRepository.findById(listId)
                .orElseThrow(() -> new ListNotFoundException("List not found"));
        listRepository.delete(list);
        return ResponseEntity.ok().build();
    }
}
