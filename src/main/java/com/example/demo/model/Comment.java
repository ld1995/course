package com.example.demo.model;

import com.example.demo.model.like.LikeComment;
import lombok.*;
import org.hibernate.search.annotations.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Indexed
@Entity
@Table(name = "demo_comment")
@Data
public class Comment extends PersistentObject {

    @ManyToOne
    private Precis precis;

    @Column(name = "date", columnDefinition="DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "demo_like", cascade = CascadeType.ALL, orphanRemoval = true)
    private LikeComment like;

    @OneToMany(mappedBy = "parent")
    private List<Comment> comments;

    @ManyToOne
    private Comment parent;


}
