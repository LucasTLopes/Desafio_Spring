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

        checkOperation(articlesPurchaseDTO);
        for (ArticlePurchaseDTO a:articlesPurchaseDTO) {
            articlesList.add(articleService.findByID(a.getProductId()));
        }

        return new Purchase(articlesList);
    }


    public void checkOperation(List <ArticlePurchaseDTO> articlesPurchaseDTO){
        List <Long> listIdsError = new ArrayList<>();
        List <String> messageError = new ArrayList<>();

        for (ArticlePurchaseDTO a:articlesPurchaseDTO) {

            if(articleService.findByID(a.getProductId()) == null){
                listIdsError.add(a.getProductId());
                messageError.add(" ID: " + a.getProductId() + "Nao cadastrado; ");
            }
            if (articleService.findByID(a.getProductId()).getQuantity() > a.getQuantity()){
                listIdsError.add(a.getProductId());
                messageError.add("Quantidade para o ID: " + a.getProductId() + "invalida");
            }
        }
        if (!listIdsError.isEmpty())
            throw new BadRequest (messageError);

    }

    // Valida se ID exist
    // Valida se Quantity

}
