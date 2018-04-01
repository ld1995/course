package com.example.course.repository;

import com.example.course.models.workbook.RatingWorkbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingWorkbookRepository extends JpaRepository<RatingWorkbook, Long> {


}
