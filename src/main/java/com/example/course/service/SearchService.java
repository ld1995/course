package com.example.course.service;

import com.example.course.converter.workbook.WorkbookToDTOConverter;
import com.example.course.dto.WorkbookDTO;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.search.SearchWorkbook;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private WorkbookToDTOConverter toDTOConverter;

    @Autowired
    private SearchWorkbook searchWorkbook;

    public boolean isValid(String query) {
        return query.matches("^[a-zA-Z0-9А-Яа-я]+");
    }

    public List<WorkbookDTO> conversionToDTO(List<Workbook> workbooks) {
        return workbooks.stream().map(workbook -> toDTOConverter.convert(workbook))
                .collect(Collectors.toList());
    }

    public List<WorkbookDTO> search(String query) throws IOException {
//        Analyzer analyzer = new StandardAnalyzer(CharArraySet.EMPTY_SET);
        if(isValid(query.trim())) {
           return conversionToDTO( (List<Workbook>) searchWorkbook.searchWorkbook(query));
        } else {
            return new ArrayList<>();
        }
    }

}
