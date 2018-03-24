package com.example.course.repository;

import com.example.course.model.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkbookRepository extends JpaRepository <Workbook, Long> {
}
