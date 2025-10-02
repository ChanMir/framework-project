package org.example.project.controller;

import org.example.project.dto.ArticleForm;
import org.example.project.entity.Article;
import org.example.project.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/articles")
    public String list(Model model) {

        List<Article> articlesEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articlesEntityList);

        System.out.println(articlesEntityList.toString());

        return "articles/list";
    }

    @GetMapping("/articles/new")
    public String newArticle() {
        return "articles/new";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        System.out.println(id);
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);

        return "articles/detail";
    }

    @PostMapping("/articles/new")
    public String create(ArticleForm form) {
        System.out.println(form.toString());
        Article article = form.toEntity();
        System.out.println(article.toString());

        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "redirect:/articles/" + saved.getId() ;
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        System.out.println("getpost: " + article.toString());
        model.addAttribute("article", article);
        return "articles/edit";
    }

    @PostMapping("/articles/{id}/edit")
    public String update(@PathVariable Long id, ArticleForm form) {
        Article article = form.toEntity();
        article.setId(id);
        System.out.println("editpost : " + article.toString());
        Article saved = articleRepository.save(article);
        return "redirect:/articles/" + saved.getId();
    }

    @PostMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:/articles";
    }
}