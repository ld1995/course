package com.example.course.controller;

import com.example.course.dto.CommentDto;
import com.example.course.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/api/private/comment/{id}")
    public CommentDto getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @PostMapping("/api/private/comment")
    public void addComment(@RequestBody @Valid CommentDto commentDto) {
        commentService.addComment(commentDto);
    }
}
