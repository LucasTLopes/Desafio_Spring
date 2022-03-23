package br.com.meli.desafio_spring.controller;

import br.com.meli.desafio_spring.dto.ArticleDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/v1/insert-articles-request")
    public ResponseEntity<List<ArticleDTO>> save(@RequestBody List<Article> articles) {
        return new ResponseEntity(articleService.saveAll(articles), HttpStatus.CREATED);
    }
}
