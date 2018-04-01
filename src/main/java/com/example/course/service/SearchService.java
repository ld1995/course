package com.example.course.service;

import org.springframework.stereotype.Service;

@Service
public class SearchService {

    public boolean isValid(String query) {
        return query.matches("^[a-zA-Z0-9А-Яа-я]+");
    }

}
