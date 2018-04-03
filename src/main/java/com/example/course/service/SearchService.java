package com.example.course.service;

import com.example.course.converter.workbook.WorkbookToDtoConverter;
import com.example.course.dto.WorkbookDto;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.search.SearchWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private WorkbookToDtoConverter toDTOConverter;

    @Autowired
    private SearchWorkbook searchWorkbook;

    public boolean isValid(String query) {
        return query.matches("^[a-zA-Z0-9А-Яа-я]+");
    }

    public List<WorkbookDto> conversionToDTO(List<Workbook> workbooks) {
        return workbooks.stream().map(workbook -> toDTOConverter.convert(workbook))
                .collect(Collectors.toList());
    }

    public List<WorkbookDto> search(String query) throws IOException {
        if(isValid(query.trim())) {
           return conversionToDTO( (List<Workbook>) searchWorkbook.searchWorkbook(query));
        } else {
            return new ArrayList<>();
        }
    }

}