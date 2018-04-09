package com.example.course.controller;

import com.example.course.dto.TagDto;
import com.example.course.models.workbook.Tag;
import com.example.course.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/api/public/tag")
    public List<TagDto> getTagList() {
        return tagService.getTagList();
    }

    @PostMapping("/api/private/tag")
    public void addTag(@RequestBody @Valid TagDto tagDto) {
        tagService.addTag(tagDto);
    }
}
