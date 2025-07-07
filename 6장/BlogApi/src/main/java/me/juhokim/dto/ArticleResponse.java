package me.juhokim.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.juhokim.domain.Article;


// DTO (Serialization)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse {

    String title;
    String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
