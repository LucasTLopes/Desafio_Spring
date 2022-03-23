package br.com.meli.desafio_spring.dto;

import br.com.meli.desafio_spring.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleSaveDTO {
    private Long productId;
    private String name;
    private int quantity;

    public static List<ArticleSaveDTO> convert(List<Article> articles) {
        return articles.stream().map(article -> new ArticleSaveDTO(article.getProductId(), article.getName(), article.getQuantity())).collect(Collectors.toList());
    }
}
