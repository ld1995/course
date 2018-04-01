package com.example.course.converter.workbook;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.CommentDTO;
import com.example.course.dto.TagDTO;
import com.example.course.dto.WorkbookDTO;
import com.example.course.models.PersistentObject;
import com.example.course.models.comment.Comment;
import com.example.course.models.question.Question;
import com.example.course.models.workbook.RatingWorkbook;
import com.example.course.models.workbook.Tag;
import com.example.course.models.workbook.Workbook;
import com.example.course.service.WorkbookService;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class WorkbookToDTOConverter extends BaseConverter <WorkbookDTO,Workbook>{

    @Autowired
    private WorkbookService workbookService;

    @Override
    protected WorkbookDTO convertOrNull(Workbook source) {
        WorkbookDTO target = new WorkbookDTO();
        BeanUtils.copyProperties(source,target,"rating, questions, comments, tags");

        target.setRating(workbookService.findRating(source.getRating()));

        List<Long> questions = source.getQuestions().stream()
                .map(PersistentObject::getId).collect(Collectors.toList());
        target.setQuestionsId(questions);

        List<Long> comments = source.getComments().stream()
                .map(PersistentObject::getId).collect(Collectors.toList());
        target.setCommentsId(comments);

        List<String> tags = source.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
        target.setTags(tags);

        return target;
    }
}

//    private Set<Tag> tags = new HashSet<>();
