package com.example.course.service;

import com.example.course.converter.workbook.WorkbookToDTOConverter;
import com.example.course.dto.WorkbookDTO;
import com.example.course.models.workbook.RatingWorkbook;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.WorkbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkbookService {

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private WorkbookToDTOConverter toDTOConverter;

    @Autowired
    private UserService userService;

    public List<WorkbookDTO> getAllWorkbookDTO() {
        return workbookRepository.findAll().stream()
                .map(workbook -> toDTOConverter.convert(workbook))
                .collect(Collectors.toList());
    }

    public int findRating(Set<RatingWorkbook> rating) {
        return rating.size() != 0 ?
                rating.stream().mapToInt(RatingWorkbook::getMark).sum() / rating.size() : 0;
    }

    public void addWorkbook(Workbook workbook) {
        workbookRepository.save(workbook);
    }
}
