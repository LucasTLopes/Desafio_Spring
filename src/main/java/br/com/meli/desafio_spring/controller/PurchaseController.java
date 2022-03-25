package br.com.meli.desafio_spring.controller;

import br.com.meli.desafio_spring.dto.ArticlePurchaseDTO;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/api/v1/purchase-request")
    public ResponseEntity<Purchase> list(@RequestBody List<ArticlePurchaseDTO> articles) {
        return new ResponseEntity(purchaseService.savePurchase(articles), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/purchases")
    public ResponseEntity<List <Purchase>> list() {
        return new ResponseEntity(purchaseService.list(), HttpStatus.OK);
    }



}
