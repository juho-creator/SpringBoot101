package me.juhokim.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public void addArticle(Body body){
        blogRepository.save(new Article(null ,body.title(),body.content()));
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    Article findArticle(@RequestParam Long code){
        return blogRepository.findById(code).get();
    }


}
