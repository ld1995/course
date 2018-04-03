package com.example.course.repository;

import com.example.course.models.user.User;
import com.example.course.models.workbook.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkbookRepository extends JpaRepository <Workbook, Long>, JpaSpecificationExecutor<Workbook> {

    Optional<List<Workbook>> findAllByAuthor_Username(String username);
}
