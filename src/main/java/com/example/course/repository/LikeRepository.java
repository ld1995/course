package com.example.course.repository;

import com.example.course.models.comment.Comment;
import com.example.course.models.comment.Like;
import com.example.course.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository <Like,Long> {

    Like existsByAuthorAndComment(User author, Comment comment);
}
