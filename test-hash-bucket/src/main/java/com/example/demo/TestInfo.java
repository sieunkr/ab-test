package com.example.demo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestInfo {
    private String name;
    private int rate;
    private List<String> components;
}