package br.com.meli.desafio_spring.controller;

import br.com.meli.desafio_spring.dto.ArticlePurchaseDTO;
import br.com.meli.desafio_spring.dto.CartDTO;
import br.com.meli.desafio_spring.dto.PurchaseDTO;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe controlador responsável por lidar com as rotas referentes ao recurso purchase.
 * Possui rotas para criação e listagem das purchases e consulta do carrinho.
 * @author Jederson Macedo
 * @author Igor Nogueira
 * @author Lucas Troleiz
 */
@RestController
public class PurchaseController {
    /**
     * {@link PurchaseService Service} de purchase injetado
     */
    @Autowired
    private PurchaseService purchaseService;

    /**
     * Endpoint responsável pela criação das purchases
     *
     * @param articles  Lista de articles para requisição de compra.
     * @return          Purchase criada.
     */
    @PostMapping("/api/v1/purchase-request")
    public ResponseEntity<PurchaseDTO> list(@RequestBody List<ArticlePurchaseDTO> articles) {
        return new ResponseEntity(purchaseService.savePurchase(articles), HttpStatus.CREATED);
    }

    /**
     * Endpoint responsável pela listagem das purchases.
     *
     * @return  Lista de purchases existentes.
     */
    @GetMapping("/api/v1/purchases")
    public ResponseEntity<List <PurchaseDTO>> list() {
        return new ResponseEntity(purchaseService.list(), HttpStatus.OK);
    }

    /**
     * Endpoint responsável pela consulta do carrinho com lista de purchases e total do carrinho.
     *
     * @return Carrinho com lista de purchases e total do carrinho
     */
    @GetMapping("/api/v1/cart")
    public ResponseEntity<CartDTO> getCart() {
        return new ResponseEntity(purchaseService.getCart(), HttpStatus.OK);
    }
}
