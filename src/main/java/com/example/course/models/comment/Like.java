package com.example.course.models.comment;

import com.example.course.models.HasAuthor;
import com.example.course.models.comment.Comment;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course_like_comment")
@Data
public class Like extends HasAuthor {

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;
}
