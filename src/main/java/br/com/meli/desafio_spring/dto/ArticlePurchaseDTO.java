package br.com.meli.desafio_spring.dto;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePurchaseDTO {

    private Long productId;
    private String name;
    private String brand;
    private int quantity;

    /*public static List<Article> convert(List<ArticlePurchaseDTO> articlePurchaseDTOs){

        return articlePurchaseDTOs.stream().map(articlePurchaseDTO -> {
            Article article = articleService.findByID(productId);
            return new Article(productId, name, article.getCategory(), brand, article.getPrice(), quantity, article.isFreeShipping(), article.getPrestige());
        }).collect(Collectors.toList());

    }*/

    /*public Article convert(ArticlePurchaseDTO){
            return new Article(productId, article.getName(), article.getCategory(), article.getBrand(), article.getPrice(), quantity, article.isFreeShipping(), article.getPrestige());
    }*/



}
