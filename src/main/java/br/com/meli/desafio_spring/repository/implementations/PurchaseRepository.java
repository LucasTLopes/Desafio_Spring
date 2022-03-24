package br.com.meli.desafio_spring.repository.implementations;

import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.repository.Repository;
import br.com.meli.desafio_spring.util.FilePurchaseUtil;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class PurchaseRepository implements Repository <Purchase>{

    private final String purchaseFileJson = "src/main/resources/purchases.json";

    private final FilePurchaseUtil fileUtil = new FilePurchaseUtil();

    private List<Purchase> purchaseList = new ArrayList<>();


    @Override
    public List<Purchase> saveAll(List<Purchase> list) {
        purchaseList.addAll(list);
        fileUtil.saveAll(purchaseList, purchaseFileJson);
        return list;
    }

    @Override
    public List<Purchase> list(String categoryName, Boolean freeShipping, String product, String brand, Short order) {
        return null;
    }

    @Override
    public Purchase findById(Long id) {
        return null;
    }
}
