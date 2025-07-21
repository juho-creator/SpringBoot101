package org.example.controller;


import org.example.domain.Article;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// WebPage
@Controller
public class BlogViewController {
    @Autowired
    ArticleService articleService;


    // [GET] Show all articles
    @GetMapping("/articles")
    public String showArticles(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "articleList";
    }


    // [GET] Show selected article
    @GetMapping("/articles/{id}")
    public String showArticles(Model model, @PathVariable long id) {
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        return "articleInfo";
    }

    // [GET] Show page for creating article
    @GetMapping("/articles/new")
    public String newArticle(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "newArticle";
    }
}
