package com.example.course.converter.rating;

import com.example.course.converter.BaseConverter;
import com.example.course.dto.RatingDto;
import com.example.course.models.user.User;
import com.example.course.models.workbook.Rating;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.UserRepository;
import com.example.course.repository.WorkbookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RatingFromDtoConverter extends BaseConverter <Rating,RatingDto> {

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected Rating convertOrNull(RatingDto source) {
        Rating target = new Rating();
        BeanUtils.copyProperties(source,target,"author, workbookId");
        Optional<User> user = userRepository.findByUsername(source.getAuthor());
        Optional<Workbook> workbook = workbookRepository.findById(source.getWorkbookId());
        if(user.isPresent() && workbook.isPresent()) {
            target.setAuthor(user.get());
            target.setWorkbook(workbook.get());
        }
        return target;
    }
}
