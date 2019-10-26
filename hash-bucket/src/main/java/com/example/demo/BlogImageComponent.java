package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class BlogImageComponent implements Consumer<Context> {

    @Override
    public void accept(Context context) {
        context.getList().add(Article.builder()
                .name("썸네일 블로그 기사")
                .thumbnail(true)
                .thumbnailUrl("http://img.springboot.co.kr/test")
                .description("테스트")
                .build());
    }
}