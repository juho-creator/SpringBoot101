package org.example.dto;

import lombok.Getter;
import org.example.domain.Article;

@Getter
public class ArticleRequest {
    String title;
    String content;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
