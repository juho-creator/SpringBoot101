package org.example.controller;

import org.example.domain.Article;
import org.example.dto.ArticleRequest;
import org.example.dto.ArticleResponse;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



// API for CRUD
@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;


    // [POST] Create an article
    @PostMapping("/api/articles")
    public ResponseEntity<Article> createArticle(@RequestBody ArticleRequest dto){
        Article newArticle = articleService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newArticle);
    }


    // [GET] Get all articles
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getArticles(){
        List<Article> articles = articleService.findAll();

        return ResponseEntity.ok(
                articles.stream()
                        .map(ArticleResponse::new)
                        .toList());
    }


    // [GET] Get an article
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable long id){
       Article article = articleService.findById(id);

        return ResponseEntity.ok(new ArticleResponse(article));
    }


    // [PUT] Update an article
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody ArticleRequest dto){
        Article article = articleService.updateById(id, dto);

        return ResponseEntity.ok(article);
    }

    // [Delete] Delete an article
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        articleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
