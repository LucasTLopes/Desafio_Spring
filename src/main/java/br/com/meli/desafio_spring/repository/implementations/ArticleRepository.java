package br.com.meli.desafio_spring.repository.implementations;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.repository.Repository;
import br.com.meli.desafio_spring.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class ArticleRepository implements Repository<Article> {
    private static List<Article> articles = new ArrayList<>();

    private final String articlesDatabase = "src/main/resources/articles.json";

    @Override
    public List<Article> saveAll(List<Article> list) {
        articles.addAll(list);

        FileUtil.saveAll(articles, articlesDatabase);

        return list;

    }

    @Override
    public List<Article> list(String category) {
        if (category != null) {
            return articles.stream().filter(article -> article.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
        }

        return articles;
    }
}
