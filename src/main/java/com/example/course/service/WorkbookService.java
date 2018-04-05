package com.example.course.service;

import com.example.course.converter.workbook.WorkbookFromDtoConverter;
import com.example.course.converter.workbook.WorkbookToDtoConverter;
import com.example.course.dto.WorkbookDto;
import com.example.course.models.workbook.Rating;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.WorkbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<WorkbookDto> getWorkbookList() {
        return workbookRepository.findAll().stream()
                .map(workbook -> toDtoConverter.convert(workbook)).sorted(
                        Comparator.comparing(WorkbookDto::getRating)
                                .thenComparing(WorkbookDto::getDate).reversed()).collect(Collectors.toList());
    }

    public WorkbookDto getWorkbook(Long id) {
        if(workbookRepository.findById(id).isPresent()) {
            return toDtoConverter.convert(workbookRepository.findById(id).get());
        } else {
            return null; //todo test
        }
    }

    public void createWorkbook(WorkbookDto workbookDto) {
        workbookRepository.save(fromDtoConverter.convert(workbookDto));
    }

    public void deleteWorkbook(Long id) {
        if(workbookRepository.findById(id).isPresent()) {//todo test
            workbookRepository.delete(workbookRepository.findById(id).get());
        }
    }

    public void updateWorkbook(WorkbookDto workbookDto) {
        Workbook workbook = fromDtoConverter.convert(workbookDto);
        if (workbookRepository.findById(workbook.getId()).isPresent()) {
            //Todo update
        }
    }

    public List<WorkbookDto> getWorkbookByUsername(String username) {
        if(workbookRepository.findAllByAuthor_Username(username).isPresent()) {
            return workbookRepository.findAllByAuthor_Username(username).get().stream()
                    .map(workbook -> toDtoConverter.convert(workbook)).sorted(
                            Comparator.comparing(WorkbookDto::getRating).reversed()).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }

    }
}