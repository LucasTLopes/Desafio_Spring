package br.com.meli.desafio_spring.service;


import br.com.meli.desafio_spring.dto.ArticlePurchaseDTO;
import br.com.meli.desafio_spring.dto.CartDTO;
import br.com.meli.desafio_spring.dto.PurchaseDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.repository.implementations.ArticleRepository;
import br.com.meli.desafio_spring.repository.implementations.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe Service responsável pelos serviços do recurso purchase
 * @author Jederson Macedo
 * @author Igor Nogueira
 * @author Lucas Troleiz
 */
@Service
public class PurchaseService {
    /**
     * {@link ArticleService Service} de article injetado
     */
    @Autowired
    private ArticleService articleService;

    /**
     * {@link PurchaseRepository Repository} de purchase injetado
     */
    @Autowired
    private PurchaseRepository purchaseRepository;

    /**
     * Cria uma nova purchase com a lista de articles informado
     *
     * @param articlesPurchaseDTO   Lista de articles para uma nova purchase
     * @return                      Purchase criado
     */
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


    /**
     * Verifica se todos os elementos da lista de articles informada existem
     *
     * @param articlesPurchaseDTO   Lista de articles informados
     */
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

    /**
     *  Obtém a lista de purchases existentes
     *
     * @return  Lista de purchases existentes
     */
    public List<PurchaseDTO> list(){
        return PurchaseDTO.convert(purchaseRepository.list());
    }

    /**
     *
     *
     * @return
     */
    public CartDTO getCart(){
        return new CartDTO(purchaseRepository.list());
    }

}
