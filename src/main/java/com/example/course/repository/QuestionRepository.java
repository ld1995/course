package com.example.course.repository;

import com.example.course.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question, Long> {
}
