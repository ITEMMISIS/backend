package com.example.backend.service;

import com.example.backend.exception.TagNotFoundException;
import com.example.backend.model.Tag;
import com.example.backend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    // Получение всех тегов
    public List<Tag> getAllTags(String token) {
        return tagRepository.findAll();
    }

    // Создание тега
    public Tag createTag(String token, Tag tag) {
        return tagRepository.save(tag);
    }

    // Удаление тега
    public ResponseEntity<Void> deleteTag(Long tagId, String token) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new TagNotFoundException("Tag not found"));
        tagRepository.delete(tag);
        return ResponseEntity.ok().build();
    }
}
