package br.com.meli.desafio_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Purchase {

    private Long id;
    private List<Article> articles;
    private BigDecimal total;

    public Purchase(List<Article> articles){
        this.id = Long.valueOf(1);
        this.articles = articles;
        this.total = articles.stream().reduce(BigDecimal.valueOf(0), (acc, price) -> acc.add(price.getPrice()), BigDecimal::add);

    }



}
