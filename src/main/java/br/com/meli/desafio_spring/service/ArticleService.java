package br.com.meli.desafio_spring.service;

import br.com.meli.desafio_spring.dto.ArticleDTO;
import br.com.meli.desafio_spring.dto.ArticleSaveDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.repository.implementations.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe Service responsável pelos serviços do recurso article
 */
@Service
public class ArticleService {

    /**
     * {@link ArticleRepository Repository} de article injetado
     */
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Salva uma lista de novos articles informado.  Verifica se os ids informados já existem antes de cadastrar e retorna os ids já
     * existentes se hpuverem ids repetidos. Salva apenas os articles que não tem id já existente.
     *
     * @param articles  Lista de articles a serem salvos
     * @return          Lista de articles criados
     */
    public List<ArticleSaveDTO> saveAll(List<Article> articles) {
         List<Long> idsAlreadyExists = articleRepository.checkDuplicateIds(articles);

         if (!idsAlreadyExists.isEmpty()) {
             for (Long id: idsAlreadyExists) {
                 articles.removeIf(article -> article.getProductId().equals(id));
             }

             articleRepository.saveAll(articles);
             throw new BadRequestException("o(s) seguinte(s) id(s) solicitados já existem: " + idsAlreadyExists.toString());
         }

        articleRepository.saveAll(articles);
        return ArticleSaveDTO.convert(articles);
    }

    /**
     * Obtém uma lista de articles com filtros e ordenações aplicadas, se informados
     *
     * @param category      Nome da categoria para filtrar
     * @param freeShipping  Frete grátis(true) ou não(false) para filtrar
     * @param product       Nome do produto para filtrar
     * @param brand         Nome da marca para filtrar
     * @param order         Código [0, 1, 2, 3] para ordenação
     * @return              Lista dos articles, após aplicação de filtros e ordenação, se informados
     */
    public List<ArticleDTO> list(String category, Boolean freeShipping, String product, String brand, Short order) {
        return ArticleDTO.convert(articleRepository.list(category, freeShipping, product, brand, order));
    }

    /**
     * Obtém um article utilizando o id como comparador
     *
     * @param id    ID informado para encontrar o article om ID correspondente
     * @return      Article encontrado
     */
    public Article findByID(Long id){
        return articleRepository.findById(id);
    }
}
