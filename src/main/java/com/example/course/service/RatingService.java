package com.example.course.service;

import com.example.course.converter.rating.RatingFromDtoConverter;
import com.example.course.converter.rating.RatingToDtoConverter;
import com.example.course.dto.RatingDto;
import com.example.course.models.workbook.Rating;
import com.example.course.repository.RatingRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RatingService {

    @Autowired
    private RatingFromDtoConverter fromDtoConverter;

    @Autowired
    private RatingRepository ratingRepository;

    public void changeRating(RatingDto ratingDTO) {
        Rating rating = fromDtoConverter.convert(ratingDTO);
        if(ratingRepository.getByAuthorAndWorkbook(rating.getAuthor(),rating.getWorkbook()) == null) {
            ratingRepository.save(rating);
        } else {
            Rating customEntity = ratingRepository.getByAuthorAndWorkbook(rating.getAuthor(),rating.getWorkbook());
            customEntity.setMark(rating.getMark());
            ratingRepository.save(customEntity);
        }
    }

    public int updateRating() {
        return findRating(Sets.newHashSet(ratingRepository.findAll()));
    }

    public Integer findRating(Set<Rating> rating) {
        return rating.size() != 0 ?
                rating.stream().mapToInt(Rating::getMark).sum() / rating.size() : 0;
    }
}
