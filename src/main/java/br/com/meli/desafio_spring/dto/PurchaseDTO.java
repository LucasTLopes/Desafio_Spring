package br.com.meli.desafio_spring.dto;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {

    private Long id;
    private List<Article> articles;
    private BigDecimal total;

    public static List<PurchaseDTO> convert(List<Purchase> purchases){
        return purchases.stream().map(purchase -> new PurchaseDTO(
                purchase.getId(),
                purchase.getArticles(),
                purchase.getTotal()
        )).collect(Collectors.toList());
    }


}
