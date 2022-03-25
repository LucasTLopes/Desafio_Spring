package br.com.meli.desafio_spring.repository.implementations;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.repository.Repository;
import br.com.meli.desafio_spring.util.FilePurchaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class PurchaseRepository implements Repository <Purchase>{

    private final String purchaseFileJson = "src/main/resources/purchases.json";

    private final FilePurchaseUtil fileUtil = new FilePurchaseUtil();

    private List<Purchase> purchases = new ArrayList<>();

    public PurchaseRepository() {
        purchases.addAll(fileUtil.readFromFile(purchaseFileJson));
    }


    @Override
    public List<Purchase> saveAll(List<Purchase> list) {
        purchases.addAll(list);
        fileUtil.saveAll(purchases, purchaseFileJson);
        return list;
    }

    public List<Purchase> list() {
        return purchases;
    }


}
