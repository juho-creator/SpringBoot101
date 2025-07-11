package me.juhokim.controller;


import me.juhokim.domain.Article;
import me.juhokim.dto.ArticleRequest;
import me.juhokim.dto.ArticleResponse;
import me.juhokim.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
     @Autowired
    ArticleService articleService;


     // [Post] Create an article
    @PostMapping("/api/articles")
    ResponseEntity<Article> saveArticle(@RequestBody ArticleRequest request){
        Article article = articleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }


    // [Get] Get all articles
    @GetMapping("/api/articles")
    ResponseEntity<List<ArticleResponse>> getAllArticles(){
        List<Article> articles = articleService.findAll();
        List<ArticleResponse> response = articles.stream()
                                                .map(ArticleResponse::new)
                                                .toList();


        return ResponseEntity.ok().body(response);
    }


    // [Get] Get an article
    @GetMapping("/api/articles/{id}")
    ResponseEntity<ArticleResponse> getArticle(@PathVariable long id){
        Article article = articleService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }



    // [Delete] Delete all articles
    @DeleteMapping("/api/articles/{id}")
    ResponseEntity<Void> deleteArticle(@PathVariable long id){
        articleService.deleteById(id);

        return ResponseEntity.ok().build();
    }


    // [Update] Update an article
    @PutMapping("/api/articles/{id}")
    ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody ArticleRequest request){
        Article article = articleService.updateById(id,request);

        return ResponseEntity.ok().body(article);
    }


}
