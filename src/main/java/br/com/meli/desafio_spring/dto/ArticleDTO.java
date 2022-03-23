package br.com.meli.desafio_spring.dto;

import br.com.meli.desafio_spring.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;

    public static List<ArticleDTO> convert(List<Article> articles) {
        return articles.stream().map(article -> new ArticleDTO(
                article.getProductId(),
                article.getName(),
                article.getCategory(),
                article.getBrand(),
                article.getPrice(),
                article.getQuantity(),
                article.isFreeShipping(),
                article.getPrestige())).collect(Collectors.toList());
    }
}
