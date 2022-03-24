package br.com.meli.desafio_spring.service;

import br.com.meli.desafio_spring.dto.ArticleDTO;
import br.com.meli.desafio_spring.dto.ArticleSaveDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.repository.implementations.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleSaveDTO> saveAll(List<Article> articles) {
         List<Long> idsAlreadyExists = articleRepository.checkDuplicateIds(articles);

         if (!idsAlreadyExists.isEmpty()) {
             for (Long id: idsAlreadyExists) {
                 articles.removeIf(article -> article.getProductId().equals(id));
             }

             articleRepository.saveAll(articles);
             throw new BadRequestException("o(s) seguinte(s) id(s) solicitados já existem: " + idsAlreadyExists.toString());
         }

        articleRepository.saveAll(articles);
        return ArticleSaveDTO.convert(articles);
    }

    public List<ArticleDTO> list(String category, Boolean freeShipping, String product, String brand, Short order) {
        return ArticleDTO.convert(articleRepository.list(category, freeShipping, product, brand, order));
    }
}
