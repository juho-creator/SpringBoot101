package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.config.jwt.TokenProvider;
import org.example.domain.User;
import org.example.dto.Article;
import org.example.repository.UserRepository;
import org.example.service.ArticleService;
import org.example.service.UserDetailService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Duration;
import java.util.List;

@Controller
public class BlogController {


    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public String showBlogs(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);

        return "articleList";
    }


    @GetMapping("/articles/{id}")
    public String showBlogs(Model model, @PathVariable long id){
        Article article = articleService.findById(id);

        model.addAttribute("article", article);

        return "articleInfo";
    }

    @GetMapping("/articles/new")
    public String newArticle(Model model){
        Article article = new Article();

        model.addAttribute("article", article);

        return "newArticle";
    }

}
