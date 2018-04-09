package com.example.course.controller;

import com.example.course.dto.RatingDto;
import com.example.course.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/api/private/workbook/rating")
    public Integer changeRating(@RequestBody @Valid RatingDto ratingDTO) {
        ratingService.changeRating(ratingDTO);
        return ratingService.updateRating();
    }
}
