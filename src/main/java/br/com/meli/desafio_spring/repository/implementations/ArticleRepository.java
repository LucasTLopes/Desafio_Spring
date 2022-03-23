package br.com.meli.desafio_spring.repository.implementations;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.repository.Repository;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class ArticleRepository implements Repository<Article> {
    private static List<Article> articles = new ArrayList<>();
    @Override
    public List<Article> saveAll(List<Article> list) {
        articles.addAll(list);

        return list;
    }
}