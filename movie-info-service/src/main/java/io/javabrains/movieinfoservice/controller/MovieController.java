package io.javabrains.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @GetMapping("/{movieId}")
    public Movie getmovieInfo(@PathVariable int movieId) {

        return new Movie(movieId, "test movie");

    }

}
