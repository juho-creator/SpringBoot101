package org.example.dto;

import lombok.Getter;
import org.example.domain.Article;

@Getter
public class ArticleResponse {
    String title;
    String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
