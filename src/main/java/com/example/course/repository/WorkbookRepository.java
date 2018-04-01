package com.example.course.repository;

import com.example.course.models.workbook.Workbook;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkbookRepository extends JpaRepository <Workbook, Long>, JpaSpecificationExecutor<Workbook> {

}
