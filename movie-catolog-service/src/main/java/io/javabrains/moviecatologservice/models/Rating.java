package io.javabrains.moviecatologservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {
    public int movieId;
    public int rating;

}
