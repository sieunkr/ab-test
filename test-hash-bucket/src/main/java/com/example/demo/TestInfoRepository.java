package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class TestInfoRepository {

    private final Map<String, TestInfo> map = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {

        map.put("A", TestInfo.builder().name("A").rate(95).components(Arrays.asList("coffeeComponent", "brunchComponent")).build());
        map.put("B", TestInfo.builder().name("B").rate(5).components(Arrays.asList("coffeeComponent")).build());
        map.put("C", TestInfo.builder().name("C").rate(0).components(Arrays.asList("coffeeComponent")).build());

        //TODO: A는 0~94,   B는 95~99
    }


    public List<String> getTestInfoByBucketNumber(int bucketNumber) {

        //map.get("A").getRate()

        if (IntStream.rangeClosed(0, 94).boxed().collect(Collectors.toList()).contains(bucketNumber)) {
            return map.get("A").getComponents();
        } else if (IntStream.rangeClosed(95, 99).boxed().collect(Collectors.toList()).contains(bucketNumber)) {
            return map.get("B").getComponents();
        }

        return null;
    }
}