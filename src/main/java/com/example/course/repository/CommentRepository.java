package com.example.course.repository;

import com.example.course.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {
}
