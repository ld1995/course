package com.example.course.repository;

import com.example.course.models.workbook.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkbookRepository extends JpaRepository <Workbook, Long>, JpaSpecificationExecutor<Workbook> {

}
