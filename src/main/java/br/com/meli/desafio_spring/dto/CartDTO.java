package br.com.meli.desafio_spring.dto;

import br.com.meli.desafio_spring.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private List<Purchase> purchases;
    private BigDecimal totalCart;

    public CartDTO(List<Purchase> purchases){
        this.purchases = purchases;
        this.totalCart = purchases.stream().reduce(BigDecimal.valueOf(0), (acc, nextPurchase) -> acc.add(nextPurchase.getTotal()), BigDecimal::add);
    }
}
