package br.com.meli.desafio_spring.controller;

import br.com.meli.desafio_spring.dto.ArticleDTO;
import br.com.meli.desafio_spring.dto.ArticleSaveDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/v1/insert-articles-request")
    public ResponseEntity<List<ArticleSaveDTO>> save(@RequestBody List<Article> articles) {
        return new ResponseEntity(articleService.saveAll(articles), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/articles")
    public ResponseEntity<List<ArticleDTO>> list(@RequestParam(required = false) String category) {
        return new ResponseEntity(articleService.list(category), HttpStatus.OK);
    }
}
