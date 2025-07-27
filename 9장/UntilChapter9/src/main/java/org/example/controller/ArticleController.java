package org.example.controller;


import org.example.domain.ArticleRequest;
import org.example.domain.ArticleResponse;
import org.example.dto.Article;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    // [POST] Create an article
    @PostMapping("/api/articles")
    public ResponseEntity<Article> createArticle(@RequestBody ArticleRequest request){
        Article createdArticle = articleService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }


    // [GET] Get all articles
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getArticles(){
        List<Article> articles =  articleService.findAll();

        return ResponseEntity.ok(articles
                                .stream()
                                .map(ArticleResponse::new)
                                .toList());
    }


    // [GET] Find an article
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findById(@PathVariable long id){
        Article article = articleService.findById(id);

        return ResponseEntity.ok(new ArticleResponse(article));
    }


    // [PUT] Update an article
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateById(@PathVariable long id, @RequestBody ArticleRequest request){
        Article article = articleService.updateById(id, request);

        return ResponseEntity.ok(article);
    }

    // [Delete] Delete an article
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        articleService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
