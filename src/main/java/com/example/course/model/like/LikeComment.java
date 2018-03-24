package com.example.course.model.like;

import com.example.course.model.Comment;
import com.example.course.model.HasAuthor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_like_comment")
@Data
public class LikeComment extends HasAuthor {

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;
}
