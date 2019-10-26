package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class BrunchComponent implements Consumer<Context> {

    @Override
    public void accept(Context ctx) {
        ctx.setPrice(ctx.getPrice() + 1100);
    }
}