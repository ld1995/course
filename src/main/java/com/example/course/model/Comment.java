package com.example.course.model;

import com.example.course.model.like.LikeComment;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_comment")
@Data
public class Comment extends HasAuthor {

    @ManyToOne
    private Workbook workbook;

    @Column(name = "date", columnDefinition="DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LikeComment> like = new HashSet<>();

    @OneToMany(mappedBy = "parent")
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    private Comment parent;


}
