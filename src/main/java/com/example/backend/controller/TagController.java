package com.example.backend.controller;

import com.example.backend.model.Tag;
import com.example.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    
    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tagService.getAllTags(token));
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestHeader("Authorization") String token, @RequestBody Tag tag) {
        return ResponseEntity.status(201).body(tagService.createTag(token, tag));
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long tagId, @RequestHeader("Authorization") String token) {
        return tagService.deleteTag(tagId, token);
    }
}
