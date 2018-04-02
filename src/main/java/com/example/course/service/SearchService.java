package com.example.course.service;

import com.example.course.converter.workbook.WorkbookToDTOConverter;
import com.example.course.dto.WorkbookDTO;
import com.example.course.models.workbook.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private WorkbookToDTOConverter toDTOConverter;

    public boolean isValid(String query) {
        return query.matches("^[a-zA-Z0-9А-Яа-я]+");
    }

    public List<WorkbookDTO> conversionToDTO(List<Workbook> workbooks) {
        return workbooks.stream().map(workbook -> toDTOConverter.convert(workbook))
                .collect(Collectors.toList());
    }

}
