package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.function.Consumer;

@Component
public class BlogTextComponent implements Consumer<Context> {

    @Override
    public void accept(Context context) {

        context.getList().add(Article.builder()
                .name("썸네일 텍스트 기사")
                .description("테스트")
                .build());
    }
}
