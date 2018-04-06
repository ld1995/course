package com.example.course.controller;

import com.example.course.dto.TagDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    @GetMapping("/api/public/tag")
    @ResponseBody
    public List<TagDto> getTagList() {
        return
    }
}
