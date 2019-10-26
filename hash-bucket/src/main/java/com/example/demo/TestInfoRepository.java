package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
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

        //TODO: A는 0~94,   B는 95~99
        map.put("A", TestInfo.builder().name("A").rate(95).components(Arrays.asList("blogTextComponent")).build());
        map.put("B", TestInfo.builder().name("B").rate(5).components(Arrays.asList("blogImageComponent")).build());
    }


    public List<String> getTestInfoByBucketNumber(Context ctx) {

        if (IntStream.rangeClosed(0, 94).boxed().collect(Collectors.toList()).contains(ctx.getBucketNumber())) {
            ctx.setVariant("A");
            return map.get("A").getComponents();
        } else if (IntStream.rangeClosed(95, 99).boxed().collect(Collectors.toList()).contains(ctx.getBucketNumber())) {
            ctx.setVariant("B");
            return map.get("B").getComponents();
        }

        return Collections.emptyList();
    }
}