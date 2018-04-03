package com.example.course.converter.rating;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.RatingDto;
import com.example.course.models.workbook.Rating;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RatingToDtoConverter extends BaseConverter <RatingDto,Rating> {

    @Override
    protected RatingDto convertOrNull(Rating source) {
        RatingDto target = new RatingDto();
        BeanUtils.copyProperties(source,target,"author, workbook");
        target.setAuthor(source.getAuthor().getUsername());
        target.setWorkbookId(source.getWorkbook().getId());
        return target;
    }
}
