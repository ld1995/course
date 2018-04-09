package com.example.course.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ApiError {

    private String key;

    private String value;

    private Object[] args;

    private String defMessage;

    public ApiError(FieldError fieldError) {
        this((ObjectError) fieldError);
        key = fieldError.getField();
    }

    public ApiError(ObjectError objectError) {
        value = objectError.getCode();
        args = objectError.getArguments();
        defMessage = objectError.getDefaultMessage();
    }

    public ApiError(String value, String defMessage) {
        this.value = value;
        this.defMessage = defMessage;
    }
}