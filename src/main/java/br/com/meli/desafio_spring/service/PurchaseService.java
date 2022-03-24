package br.com.meli.desafio_spring.service;


import br.com.meli.desafio_spring.dto.ArticlePurchaseDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private ArticleService articleService;

    public Purchase savePurchase(List <ArticlePurchaseDTO> articlesPurchaseDTO){

        List<Article> articlesList = new ArrayList<>();

        for (ArticlePurchaseDTO a:articlesPurchaseDTO) {
            articlesList.add(articleService.findByID(a.getProductId()));
        }

        return new Purchase(articlesList);
    }



}
