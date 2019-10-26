package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CafeServiceTest {

    @Autowired
    private CafeService cafeService;

    @Test
    public void aa(){

        int expectedPriceA = 2400;
        int expectedPriceB = 1300;

        assertEquals(expectedPriceA, cafeService.testA(30));
        assertEquals(expectedPriceA, cafeService.testA(94));
        assertEquals(expectedPriceA, cafeService.testA(0));
        assertNotEquals(expectedPriceA, cafeService.testA(95));

        assertEquals(expectedPriceB, cafeService.testA(96));
        assertEquals(expectedPriceB, cafeService.testA(99));

    }
}