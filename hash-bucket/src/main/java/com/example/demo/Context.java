package com.example.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Context {

    private String keyword;
    private String uuid;
    private List<Article> list = new ArrayList<>();

}