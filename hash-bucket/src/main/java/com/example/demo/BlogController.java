package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public List<Article> findAll(HttpSession session){

        Context ctx = new Context();
        ctx.setKeyword("스프링부트");
        ctx.setUuid(session.getId());

        return blogService.findAll(ctx);
    }
}