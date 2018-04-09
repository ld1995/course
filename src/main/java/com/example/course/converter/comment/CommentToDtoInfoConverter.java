package com.example.course.converter.comment;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.CommentInfoDto;
import com.example.course.models.comment.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CommentToDtoInfoConverter extends BaseConverter <CommentInfoDto, Comment> {

    @Override
    protected CommentInfoDto convertOrNull(Comment source) {
        CommentInfoDto target = new CommentInfoDto();
        BeanUtils.copyProperties(source,target,"author", "like", "comments","parent");
        target.setUsername(source.getAuthor().getUsername());
        target.setWorkbookId(source.getWorkbook().getId());
        target.setContent(source.getContent());
        if (source.getParent() != null) {
            target.setParentId(source.getParent().getId());
        }
        return target;
    }
}
