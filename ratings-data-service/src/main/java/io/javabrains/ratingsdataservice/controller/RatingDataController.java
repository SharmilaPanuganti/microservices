package io.javabrains.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.models.Rating;
import io.javabrains.ratingsdataservice.models.UserRatings;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataController {
    @GetMapping("/{movieId}")
    public Rating getrating(@PathVariable int movieId) {

        return new Rating(movieId, 4);

    }

    @GetMapping("users/{userId}")
    public UserRatings getMovies(@PathVariable int userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating(1000, 3),
                new Rating(1002, 50),
                new Rating(1003, 4));

        return UserRatings.builder().user_ratings(ratings).build();

    }

}
