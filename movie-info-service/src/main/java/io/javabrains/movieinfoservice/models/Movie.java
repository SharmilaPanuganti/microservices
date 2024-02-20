package io.javabrains.movieinfoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    public int movieId;
    public String name;
}
