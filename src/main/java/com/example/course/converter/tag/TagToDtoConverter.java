package com.example.course.converter.tag;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.TagDto;
import com.example.course.models.PersistentObject;
import com.example.course.models.workbook.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagToDtoConverter extends BaseConverter <TagDto,Tag> {

    @Override
    protected TagDto convertOrNull(Tag source) {
        TagDto target = new TagDto();
        BeanUtils.copyProperties(source,target,"workbooks");
        List<Long> workbookListId = source.getWorkbooks().stream()
                .map(PersistentObject::getId).collect(Collectors.toList());
        target.setWorkbookListId(workbookListId);
        return target;
    }
}
