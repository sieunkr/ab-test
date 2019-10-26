package com.example.demo;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BucketComponent implements BucketUseCase {

    private static int BUCKET_SIZE = 100;
    private final TestInfoRepository testInfoRepository;

    @Override
    public int getBucketNumberById(String id) {

        return Hashing.consistentHash(
                Hashing.sha256().hashString(id, Charsets.UTF_8), BUCKET_SIZE
        );
    }

    @Override
    public List<String> getTestInfoByBucketNumber(int bucketNumber) {

        
        return testInfoRepository.getTestInfoByBucketNumber(bucketNumber);
    }


}