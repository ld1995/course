package com.example.course.service;

import com.example.course.converter.comment.CommentToDtoConverter;
import com.example.course.converter.workbook.WorkbookFromDtoConverter;
import com.example.course.converter.workbook.WorkbookToDtoConverter;
import com.example.course.dto.CommentDto;
import com.example.course.dto.WorkbookDto;
import com.example.course.models.workbook.Rating;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.WorkbookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkbookService {

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private WorkbookToDtoConverter toDtoConverter;

    @Autowired
    private WorkbookFromDtoConverter fromDtoConverter;

    @Autowired
    private CommentToDtoConverter commentToDtoConverter;


    public List<WorkbookDto> getWorkbookList() {
        return workbookRepository.findAll().stream()
                .map(workbook -> toDtoConverter.convert(workbook)).sorted(
                        Comparator.comparing(WorkbookDto::getRating)
                                .thenComparing(WorkbookDto::getDate).reversed()).collect(Collectors.toList());
    }

    public WorkbookDto getWorkbook(Long id) {
        if(workbookRepository.findById(id).isPresent()) {
            return toDtoConverter.convert(workbookRepository.findById(id).get());
        }
        return null;
    }

    public void addWorkbook(WorkbookDto workbookDto) {
        workbookRepository.save(fromDtoConverter.convert(workbookDto));
    }

    public void deleteWorkbook(Long id) {
        workbookRepository.delete(workbookRepository.findById(id).get());
    }

    public void updateWorkbook(WorkbookDto workbookDto) {
        Workbook modified  = fromDtoConverter.convert(workbookDto);
        if (workbookRepository.findById(modified.getId()).isPresent()) {
            workbookRepository.save(modified);
        }
    }

    public List<WorkbookDto> getWorkbookByUsername(String username) {
        if(workbookRepository.findAllByAuthor_Username(username).isPresent()) {
            return workbookRepository.findAllByAuthor_Username(username).get().stream()
                    .map(workbook -> toDtoConverter.convert(workbook)).sorted(
                            Comparator.comparing(WorkbookDto::getRating).reversed()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<CommentDto> getCommentListByWorkbookId(Long id) {
        if (workbookRepository.findById(id).isPresent()) {
            return workbookRepository.findById(id).get().getComments().stream()
                    .filter(comment -> comment.getParent() == null)
                    .map(commentToDtoConverter::convert)
                    .sorted(Comparator.comparing(CommentDto::getDate).thenComparing(CommentDto::getId))
                    .collect(Collectors.toList());
        }
        return null;
    }
}