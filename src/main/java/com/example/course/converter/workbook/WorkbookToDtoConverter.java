package com.example.course.converter.workbook;

import com.example.course.converter.BaseConverter;
import com.example.course.converter.comment.CommentToDtoConverter;
import com.example.course.dto.CommentDto;
import com.example.course.dto.WorkbookDto;
import com.example.course.models.PersistentObject;
import com.example.course.models.comment.Comment;
import com.example.course.models.workbook.Tag;
import com.example.course.models.workbook.Workbook;
import com.example.course.service.RatingService;
import com.example.course.service.WorkbookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class WorkbookToDtoConverter extends BaseConverter <WorkbookDto,Workbook>{

    @Autowired
    private RatingService ratingService;

    @Autowired
    private CommentToDtoConverter commentConverter;

    @Override
    protected WorkbookDto convertOrNull(Workbook source) {
        WorkbookDto target = new WorkbookDto();
        BeanUtils.copyProperties(source,target,"author","rating, questions, comments, tags");

        target.setUsername(source.getAuthor().getUsername());

        target.setRating(ratingService.findRating(source.getRating()));

        List<Long> questions = source.getQuestions().stream()
                .map(PersistentObject::getId).collect(Collectors.toList());
        target.setQuestionsId(questions);

        List<CommentDto> comments = source.getComments().stream()
                .filter(comment -> comment.getParent() == null)
                .map(commentConverter::convert)
                .sorted(Comparator.comparing(CommentDto::getDate).thenComparing(CommentDto::getId))
                .collect(Collectors.toList());
        target.setComments(comments);

        List<String> tags = source.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
        target.setTags(tags);

        return target;
    }
}
