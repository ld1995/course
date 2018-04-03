package com.example.course.controller;

import com.example.course.dto.RatingDto;
import com.example.course.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/api/private/workbook/rating", method = RequestMethod.POST, produces = "application/json")
    public Integer changeRating(@RequestBody @Valid RatingDto ratingDTO) {
        ratingService.changeRating(ratingDTO);
        return ratingService.updateRating();
    }
}
