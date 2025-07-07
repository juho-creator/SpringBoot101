package me.juhokim.dto;


// DTO for deserialization

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.juhokim.domain.Article;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
