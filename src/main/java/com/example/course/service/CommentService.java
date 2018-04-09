package com.example.course.service;

import com.example.course.converter.comment.CommentFromDtoConverter;
import com.example.course.converter.comment.CommentToDtoConverter;
import com.example.course.converter.comment.CommentToDtoInfoConverter;
import com.example.course.dto.CommentDto;
import com.example.course.dto.CommentInfoDto;
import com.example.course.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentToDtoConverter toDtoConverter;

    @Autowired
    private CommentFromDtoConverter fromDtoConverter;

    public CommentDto getComment(Long id) {
        if(commentRepository.findById(id).isPresent()) {
            return toDtoConverter.convert(commentRepository.findById(id).get());
        }
        return null;
    }

    public void addComment(CommentDto commentDto) {
        commentRepository.save(fromDtoConverter.convert(commentDto));
    }
}
