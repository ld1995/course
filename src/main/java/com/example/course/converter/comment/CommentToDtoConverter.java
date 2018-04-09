package com.example.course.converter.comment;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.CommentDto;
import com.example.course.models.comment.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentToDtoConverter extends BaseConverter <CommentDto, Comment> {

    @Override
    protected CommentDto convertOrNull(Comment source) {
        CommentDto target = new CommentDto();
        BeanUtils.copyProperties(source,target,"author", "like", "comments","parent");

        target.setUsername(source.getAuthor().getUsername());

        //todo like

        target.setWorkbookId(source.getWorkbook().getId());

        if (!source.getContent().isEmpty()) {
            List<CommentDto> comments = source.getComments().stream()
                    .map(this::convert).collect(Collectors.toList());
            target.setComments(comments);
        }
        return target;
    }
}

