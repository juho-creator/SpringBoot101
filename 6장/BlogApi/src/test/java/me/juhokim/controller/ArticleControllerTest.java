package me.juhokim.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.juhokim.domain.Article;
import me.juhokim.dto.ArticleRequest;
import me.juhokim.repository.ArticleRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {
    @Autowired
    MockMvc mockmvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ArticleRepository articleRepository;

    // Intial data for testing
    String title = "title1";
    String content = "content1";
    String url = "/api/articles";



    @BeforeEach
    public void setMockmvc(){
        this.mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
        articleRepository.deleteAll();
    }


    // [Post] Create an article
    @Test
    public void createArticleTest() throws Exception{
        // 1. Create new article object
        ArticleRequest request = new ArticleRequest(title, content);

        // 2. Object -> Json
        String params = objectMapper.writeValueAsString(request);

        // 3. [Post] Create article
        ResultActions response = mockmvc.perform(post(url)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(params));

        // 4. Inspect database
        List<Article> articles = articleRepository.findAll();


        // 5. Compare initial data with actual data
        response.andExpect(status().isCreated());
        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getContent()).isEqualTo(content);
    }


    // [Get] Find all articles
    @Test
    public void getArticlesTest() throws Exception{
        // 1. Input dummy data
        Article article = Article.builder()
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);


        // 2. Get request for creating an article
        ResultActions response = mockmvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON));


        // 3. Compare actual data with initial data
        response.andExpect(status().isOk());
        response.andExpect(jsonPath("$[0].title").value(title));
        response.andExpect(jsonPath("$[0].content").value(content));
    }


    // [Get] Find an article
    @Test
    public void getArticleTest() throws Exception {
        String url = "/api/articles/";

        // 1. Input dummy data
        Article article = Article.builder()
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);


        // 2. [Get] Request an article
        ResultActions response = mockmvc.perform(get(url+article.getId())
                .contentType(MediaType.APPLICATION_JSON));


        // 3. Compare actual data with initial data
        response.andExpect(status().isOk());
        response.andExpect(jsonPath("$.title").value(title));
        response.andExpect(jsonPath("$.content").value(content));
    }


    // [Delete] Delete an article
    @Test
    public void deleteArticleTest() throws Exception {
        String url = "/api/articles/";

        // 1. Input dummy data
        Article article = Article.builder()
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);

        // 2. Request for deleting article
        ResultActions response = mockmvc.perform(delete(url+article.getId())
                .contentType(MediaType.APPLICATION_JSON));

        // 3. Check if database is empty
        List<Article> articles = articleRepository.findAll();
        response.andExpect(status().isOk());
        assertThat(articles.size()).isEqualTo(0);
    }
}