package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogService {

    private final Map<String, Consumer<Context>> consumerMap;
    private final BucketComponent bucketComponent;
    private final TestInfoRepository testInfoRepository;

    public List<Article> findAll(Context ctx) {

        Assert.notNull(ctx.getUuid(), "UUID must not be null");

        int bucketNumber = bucketComponent.getBucketNumberById(ctx.getUuid());

        log.info("Bucket Number:" + bucketNumber);

        List<String> taskList = testInfoRepository.getTestInfoByBucketNumber(bucketNumber);

        run(taskList, ctx);

        return ctx.getList();
    }

    private void run(List<String> tasks, Context c) {
        tasks.forEach(t -> consumerMap.get(t).accept(c));
    }

}
