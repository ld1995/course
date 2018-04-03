package com.example.course.repository;

import com.example.course.models.user.User;
import com.example.course.models.workbook.Rating;
import com.example.course.models.workbook.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Rating getByAuthorAndWorkbook(User author, Workbook workbook);
}
