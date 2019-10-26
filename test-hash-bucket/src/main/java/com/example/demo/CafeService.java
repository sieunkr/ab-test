package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {

    private final Map<String, Consumer<Context>> consumerMap;
    private final BucketComponent bucketComponent;
    private final TestInfoRepository testInfoRepository;


    public int testBySessionID(String id){

        Context c = new Context();

        int i = bucketComponent.getBucketNumberById(id);

        log.info("bucket ID:" + i);

        List<String> taskList = testInfoRepository.getTestInfoByBucketNumber(i);

        run(taskList, c);

        return c.getPrice();
    }


    public int testA(int bucketNumber){

        Context c = new Context();

        //UUID uuid =
        String uuid = "test-a";
        int i = bucketComponent.getBucketNumberById(uuid);

        List<String> taskList = testInfoRepository.getTestInfoByBucketNumber(bucketNumber);

        run(taskList, c);

        return c.getPrice();
    }

    private void run(List<String> tasks, Context c){
        tasks.forEach(t -> consumerMap.get(t).accept(c));
    }
}