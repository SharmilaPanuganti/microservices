package io.javabrains.moviecatologservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CatalogItem {

    private String name;
    private String desc;
    private int rating;

}
