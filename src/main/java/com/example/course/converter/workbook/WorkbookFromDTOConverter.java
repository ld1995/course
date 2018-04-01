package com.example.course.converter.workbook;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.WorkbookDTO;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.TagRepository;
import com.example.course.repository.WorkbookRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class WorkbookFromDTOConverter extends BaseConverter <Workbook, WorkbookDTO> {

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    protected Workbook convertOrNull(WorkbookDTO source) {
        Workbook target = new Workbook();
        BeanUtils.copyProperties(source,target,"rating, questions, comments, tags");
//        if (source.getRating())
//        target.setRating(workbookRepository.findOne(source.getRating()));
//        target.setRating(workbookRepository.findOne(source.getQuestionsId()));
        return target;
    }
}

//Category target = new Category();
//        BeanUtils.copyProperties(source, target, "parent");
//        if (source.getParent() != null) {
//            target.setParent(categoryService.findOne(source.getParent()));
//        }
//        return target;
