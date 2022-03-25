package br.com.meli.desafio_spring.repository;

import br.com.meli.desafio_spring.entity.Article;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> saveAll(List<T> list);


}
