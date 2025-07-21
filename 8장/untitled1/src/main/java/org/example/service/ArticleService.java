package org.example.service;

import org.example.domain.Article;
import org.example.dto.ArticleRequest;
import org.example.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;


    // [POST] Create an article
    public Article save(ArticleRequest dto){
        return articleRepository.save(dto.toEntity());
    }

    // [GET] Get all articles
    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    // [GET] Get an article
    public Article findById(long id){
        return articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found " + id));
    }

    // [PUT] Update an article
    public Article updateById(long id, ArticleRequest dto){
        Article currentArticle = articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found " + id));

        currentArticle.update(dto.getTitle(), dto.getContent());

        articleRepository.save(currentArticle);

        return currentArticle;
    }

    // [Delete] Delete an article
    public void deleteById(long id){
        articleRepository.deleteById(id);
    }
}
