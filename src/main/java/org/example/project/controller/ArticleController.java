package org.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/articles/new")
    public String newArticle() {
        return "articles/new";
    }

    @GetMapping("/articles/{id}")
    public String show() {
        return "articles/detail";
    }

    @PostMapping("/articles/new")
    {
        return "";
    }

}
