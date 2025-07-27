package org.example.domain;

import lombok.Getter;
import org.example.dto.Article;

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
