package me.juhokim.service;


import me.juhokim.domain.Article;
import me.juhokim.dto.ArticleRequest;
import me.juhokim.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article save(ArticleRequest request){
        return articleRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Article findById(long id){
        return articleRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found " + id));
    }

    public void deleteById(long id){
        articleRepository.deleteById(id);
    }

    public Article updateById(long id, ArticleRequest request){
        // Find specific entity
        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found " + id));

        // Get new article
        Article newArticle = request.toEntity();

        // Update article based on new information
         article.update(newArticle.getTitle(), newArticle.getContent());
         articleRepository.save(article);

         // Return updated article
        return article;
    }
}
