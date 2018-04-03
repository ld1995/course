package com.example.course.converter.workbook;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.WorkbookDto;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkbookFromDtoConverter extends BaseConverter <Workbook,WorkbookDto> {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected Workbook convertOrNull(WorkbookDto source) {
        Workbook target = new Workbook();
        BeanUtils.copyProperties(source,target,"author", "rating, questions, comments, tags");
        target.setAuthor(userRepository.findByUsername(source.getUsername()).get());
        return target;
    }
}