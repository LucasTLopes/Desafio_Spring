package br.com.meli.desafio_spring.service;

import br.com.meli.desafio_spring.dto.ArticleDTO;
import br.com.meli.desafio_spring.dto.ArticleSaveDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.repository.implementations.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleSaveDTO> saveAll(List<Article> articles) {
        return ArticleSaveDTO.convert(articleRepository.saveAll(articles));
    }

    public List<ArticleDTO> listAll(String categoryName) {
        return ArticleDTO.convert(articleRepository.listAll(categoryName));
    }
}
