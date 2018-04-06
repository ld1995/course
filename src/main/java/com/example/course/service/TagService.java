package com.example.course.service;

import com.example.course.dto.TagDto;
import com.example.course.dto.WorkbookDto;
import com.example.course.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<TagDto> getTagList() {
        return tagRepository.findAll().stream()
                .map(workbook -> toDtoConverter.convert(workbook)).collect(Collectors.toList());;
    }
}
