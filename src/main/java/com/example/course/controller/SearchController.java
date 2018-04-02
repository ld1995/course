package com.example.course.controller;

import com.example.course.dto.WorkbookDTO;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.search.SearchWorkbook;
import com.example.course.service.SearchService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "/api/public/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping
    @ResponseBody
    public List<WorkbookDTO> resultSearch(@RequestBody String query) throws IOException {
        return searchService.search(query);
    }
    //https://stackoverflow.com/questions/13765698/getting-error-on-a-specific-query
}