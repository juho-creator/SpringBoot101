package org.example.service;


import org.example.domain.ArticleRequest;
import org.example.dto.Article;
import org.example.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    // Create an article
    public Article save(ArticleRequest request){
        return articleRepository.save(request.toEntity());
    }


    // Get all articles
    public List<Article> findAll(){
        return articleRepository.findAll();
    }


    // Find an article
    public Article findById(long id){
        return articleRepository.findById(id);

    }


    // Update an article
    public Article updateById(long id, ArticleRequest request){

            // 1. Get existing article
            Article article = articleRepository.findById(id);

            // 2. Get new article
            Article newArticle = request.toEntity();

            // 3. Update article
            article.update(newArticle.getTitle(), newArticle.getContent());
            articleRepository.save(article);

            return article;
    }

    // Delete an article
    public void deleteById(long id){
        articleRepository.deleteById(id);
    }


}
