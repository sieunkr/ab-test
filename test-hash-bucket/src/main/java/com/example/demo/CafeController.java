package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    @GetMapping
    public Integer test(HttpSession session, @CookieValue(value="SESSION", required = false) Cookie storeIdCookie){

        log.info(session.getId());

        //TODO:NullPointerException
        log.info(storeIdCookie.getName());

        return cafeService.testBySessionID(session.getId());
    }
}