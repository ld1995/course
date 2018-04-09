package com.example.course.converter.comment;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.CommentDto;
import com.example.course.models.comment.Comment;
import com.example.course.repository.CommentRepository;
import com.example.course.repository.UserRepository;
import com.example.course.repository.WorkbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentFromDtoConverter extends BaseConverter <Comment,CommentDto> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    protected Comment convertOrNull(CommentDto source) {
        Comment target = new Comment();
        target.setAuthor(userRepository.findByUsername(source.getUsername()).get());
        target.setWorkbook(workbookRepository.findById(source.getWorkbookId()).get());
        target.setContent(source.getContent());
        if (source.getParentId() != null) {
            target.setParent(commentRepository.getOne(source.getParentId()));
        }
        return target;
    }
}