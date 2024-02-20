package io.javabrains.moviecatologservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    public int movieId;
    public String name;
}
