package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Article {

    private String name;
    private boolean thumbnail;
    private String thumbnailUrl;
    private String description;
}