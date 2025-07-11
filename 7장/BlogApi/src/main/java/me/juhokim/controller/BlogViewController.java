package me.juhokim.controller;

import lombok.RequiredArgsConstructor;
import me.juhokim.domain.Article;
import me.juhokim.dto.ArticleListViewResponse;
import me.juhokim.dto.ArticleViewResponse;
import me.juhokim.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final ArticleService articleService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = articleService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = articleService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required=false) Long id, Model model){
        // id가 있으면 생성
        if (id == null){
            model.addAttribute("article",new ArticleViewResponse());
        } else{ // id가 있으면 수정
            Article article = articleService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
