package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BucketComponent.class)
public class BucketComponentTest {

    @Autowired
    private BucketComponent bucketComponent;

    @Test
    public void test() {

        int expectedBucketNumber = 95;

        int activeBucketNumber =
                bucketComponent.getBucketNumberById("test-01");

        assertEquals(expectedBucketNumber, activeBucketNumber);
    }

}