package me.juhokim.SpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogApiController {
    @Autowired
    BlogService blogService;

    // 블로그 작성하기
    @PostMapping("/api/articles")
    public void addArticle(@RequestBody Body body){
        blogService.addArticle(body);
    }

    // 블로그 전체 조회하기
    @GetMapping("/api/articles")
    List<Article> findAllArticles(){
        return blogService.findAll();
    }

    // 블로그 글 하나 조회하기 (IDK <= not working at the moment)
    @GetMapping("/api/articles/")
    Article findArticle(@RequestParam Long code){
        return blogService.findArticle(code);
    }

    // 블로그 글 삭제 (IDK)


    // 블로그 글 수정 (IDK)


}

record Body(String title, String content){}