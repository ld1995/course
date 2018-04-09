package com.example.course.errors;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ApiErrorConverter {

    private ApiErrorConverter() {
    }

    public static List<ApiError> convert(BindingResult bindingResult) {
        List<ApiError> result = new ArrayList<>();
        result.addAll(bindingResult.getFieldErrors().stream().map(ApiError::new).collect(toList()));
        result.addAll(bindingResult.getGlobalErrors().stream().map(ApiError::new).collect(toList()));
        return result;
    }
}
