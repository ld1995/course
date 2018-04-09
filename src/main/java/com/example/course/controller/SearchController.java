package com.example.course.controller;

import com.example.course.dto.WorkbookDto;
import com.example.course.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/api/public/search")
    public List<WorkbookDto> resultSearch(@RequestBody String query) throws IOException {
        return searchService.search(query);
    }
    //https://stackoverflow.com/questions/13765698/getting-error-on-a-specific-query
}