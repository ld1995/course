package com.example.course.controller;

import com.example.course.repository.search.SearchWorkbook;
import com.example.course.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/public/search")
public class SearchController {

    @Autowired
    private SearchWorkbook searchWorkbook;

    @Autowired
    private SearchService searchService;

    @PostMapping
    @ResponseBody
    public ResponseEntity resultSearch(@RequestBody String query){
        if(searchService.isValid(query.trim())) {
            return ResponseEntity.ok(searchWorkbook.searchWorkbook(query));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //https://stackoverflow.com/questions/13765698/getting-error-on-a-specific-query
}