package br.com.meli.desafio_spring.controller;

import br.com.meli.desafio_spring.dto.ArticleDTO;
import br.com.meli.desafio_spring.dto.ArticlePurchaseDTO;
import br.com.meli.desafio_spring.dto.ArticleSaveDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.service.ArticleService;
import br.com.meli.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Classe controlador responsável por lidar com as rotas referentes ao recursp article.
 *  Possui rotas para criação e listagem com filtros e ordenações dos articles.
 *
 * @author Arthur Guedes
 * @author Luís Felipe Olimpio
 * @author Jeferson Barbosa
 * */
@RestController
public class ArticleController {

    /**
     * {@link ArticleService Service} de article injetado
     */
    @Autowired
    private ArticleService articleService;

    /**
     * Endpoint responsável pela criação dos articles
     *
     * @param articles Lista de articles a serem cadastrados
     * @return         Lista de articles que foram criados ou mensagem informando ids que já existem, se houver
     */
    @PostMapping("/api/v1/insert-articles-request")
    public ResponseEntity<List<ArticleSaveDTO>> save(@RequestBody List<Article> articles) {
        return new ResponseEntity(articleService.saveAll(articles), HttpStatus.CREATED);
    }

    /**
     *  Endpoint responsável pela listagem dos articles cadastrados com filtros e ordenações, se informado
     *
     * @param category      Nome da categoria para filtrar
     * @param freeShipping  Frete grátis(true) ou não(false) para filtrar
     * @param product       Nome do produto para filtrar
     * @param brand         Nome da marca para filtrar.
     * @param order         Código [0, 1, 2, 3] para ordenação.
     * @return              Lista dos articles, após aplicação de filtros e ordenação, se informados
     */
    @GetMapping("/api/v1/articles")
    public ResponseEntity<List<ArticleDTO>> list(
            @RequestParam(required = false, value = "category") String category,
            @RequestParam(required = false, value = "freeShipping") Boolean freeShipping,
            @RequestParam(required = false, value = "product") String product,
            @RequestParam(required = false, value = "brand") String brand,
            @RequestParam(required = false, value = "order") Short order) {
        return new ResponseEntity(articleService.list(category, freeShipping, product, brand, order), HttpStatus.OK);
    }





}
