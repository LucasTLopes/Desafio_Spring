package br.com.meli.desafio_spring.repository.implementations;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.repository.Repository;
import br.com.meli.desafio_spring.util.FileArticleUtil;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class ArticleRepository implements Repository<Article> {
    private static List<Article> articles = new ArrayList<>();

    private final String articlesFileJson = "src/main/resources/articles.json";

    private final FileArticleUtil fileUtil = new FileArticleUtil();

    public ArticleRepository() {
        articles.addAll(fileUtil.readFromFile(articlesFileJson));
    }

    @Override
    public List<Article> saveAll(List<Article> list) {

        articles.addAll(list);
        fileUtil.saveAll(articles, articlesFileJson);

        return list;

    }

    @Override
    public List<Article> list(String category, Boolean freeShipping, String product, String brand, Short order) {
        Object[] args = {product, category, brand, freeShipping};

        if(Arrays.stream(args).filter(Objects::nonNull).count() > 2) {
            throw new BadRequestException("favor informar no máximo 2 parâmetros para o filtro.");
        }

        return articles
                .stream()
                .filter(article -> filterByCategory(article, category))
                .filter(article -> filterByFreeShipping(article, freeShipping))
                .filter(article -> filterByProductName(article, product))
                .filter(article -> filterByBrandName(article, brand))
                .sorted(orderBy(order))
                .collect(Collectors.toList());
    }

    public Boolean filterByCategory(Article article, String category) {
        return category == null || article.getCategory().equalsIgnoreCase(category);
    }

    public Boolean filterByFreeShipping(Article article, Boolean freeShipping) {
        if (freeShipping != null) {
            if (freeShipping) {
                return article.isFreeShipping();
            } else {
                return !article.isFreeShipping();
            }
        }

        return true;
    }

    public Boolean filterByProductName(Article article, String product) {
        return product == null || article.getName().equalsIgnoreCase(product);
    }

    public Boolean filterByBrandName(Article article, String brand) {
        return brand == null || article.getBrand().equalsIgnoreCase(brand);
    }

    public Comparator<Article> orderBy(Short order) {
        if (order == null) return Comparator.comparing(Article::getProductId);

        switch(order) {
            case 0: return Comparator.comparing(Article::getName);
            case 1: return Comparator.comparing(Article::getName).reversed();
            case 2: return Comparator.comparing(Article::getPrice).reversed();
            case 3: return Comparator.comparing(Article::getPrice);
            default: throw new BadRequestException("Favor informar um parâmetro para order entre 0 e 3 ou omiti-lo.");
        }
    }

    public List<Long> checkDuplicateIds(List<Article> list) {
        List<Long> idsAlreadyExists = new ArrayList<>();

        for (Article article: list) {
            if (articles.stream().anyMatch(a -> a.getProductId().equals(article.getProductId()))) {
                idsAlreadyExists.add(article.getProductId());
            }
        }

        return idsAlreadyExists;
    }

    @Override
    public Article findById(Long id) {
        return articles.stream().filter(article -> article.getProductId().equals(id)).findAny().orElse(null);
    }


}
