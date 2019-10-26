package com.example.demo;

import java.util.List;

public interface BucketUseCase {
    int getBucketNumberById(String id);
    List<String> getTestInfoByBucketNumber(int bucketNumber);
}