package br.com.meli.desafio_spring.service;


import br.com.meli.desafio_spring.dto.ArticlePurchaseDTO;
import br.com.meli.desafio_spring.dto.CartDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.repository.implementations.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PurchaseRepository purchaseRepository;


    public List<Purchase> savePurchase(List <ArticlePurchaseDTO> articlesPurchaseDTO){

        List<Article> articlesList = new ArrayList<>();
        List<Purchase> purchaseList = new ArrayList<>();


        checkOperation(articlesPurchaseDTO);
        for (ArticlePurchaseDTO a:articlesPurchaseDTO) {
            Article article = articleService.findByID(a.getProductId());
            articlesList.add(new Article(a.getProductId(), article.getName(), article.getCategory(), article.getBrand(), article.getPrice(), a.getQuantity(), article.isFreeShipping(), article.getPrestige()));
        }

        purchaseList.add(new Purchase(articlesList));

        return purchaseRepository.saveAll(purchaseList);

    }


    public void checkOperation(List <ArticlePurchaseDTO> articlesPurchaseDTO){
        List <Long> listIdsError = new ArrayList<>();
        List <String> messageError = new ArrayList<>();

        for (ArticlePurchaseDTO a:articlesPurchaseDTO) {

            if(articleService.findByID(a.getProductId()) == null){
                listIdsError.add(a.getProductId());
                messageError.add(" ID: " + a.getProductId() + " não cadastrado; ");
            }
            else if (articleService.findByID(a.getProductId()).getQuantity() < a.getQuantity()){
                listIdsError.add(a.getProductId());
                messageError.add("quantidade para o ID: " + a.getProductId() + " inválida");
            }
        }
        if (!listIdsError.isEmpty())
            throw new BadRequestException (messageError.toString());
    }

    public List<Purchase> list(){
        return purchaseRepository.list();
    }

    public CartDTO getCart(){
        CartDTO responseCartDTO = new CartDTO(purchaseRepository.list());
        return responseCartDTO;
    }

    // Valida se ID exist
    // Valida se Quantity

}
