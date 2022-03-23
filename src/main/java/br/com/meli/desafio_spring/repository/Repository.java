package br.com.meli.desafio_spring.repository;

import java.util.List;

public interface Repository<T> {
    List<T> saveAll(List<T> list);
    List<T> listAll(String categoryName);
}
