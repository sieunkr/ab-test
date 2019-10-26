package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class CoffeeComponent implements Consumer<Context> {

    @Override
    public void accept(Context ctx) {
        ctx.setPrice(ctx.getPrice() + 1300);
    }
}