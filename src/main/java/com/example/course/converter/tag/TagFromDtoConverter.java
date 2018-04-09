package com.example.course.converter.tag;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.TagDto;
import com.example.course.models.workbook.Tag;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TagFromDtoConverter extends BaseConverter <Tag,TagDto> {

    @Autowired
    private TagRepository tagRepository;

    @Override
    protected Tag convertOrNull(TagDto source) {
        Tag target = new Tag();
        BeanUtils.copyProperties(source,target, "workbookListId");
//        if (!source.getWorkbookListId().isEmpty()) {  //нужна ли свзь и как удалять из связной таблицы
//            Set<Workbook> workbooks = new HashSet<>();
//            source.getWorkbookListId().forEach(id -> workbooks.add(tagRepository.findById(id).get().));
//            target.setWorkbooks(workbooks);
//        }
        return target;
    }
}
