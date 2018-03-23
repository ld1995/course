package com.example.demo.model.like;

import com.example.demo.model.Comment;
import com.example.demo.model.PersistentObject;
import com.example.demo.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "demo_like_comment")
@Data
public class LikeComment extends PersistentObject {

    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
