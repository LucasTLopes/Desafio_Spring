package br.com.meli.desafio_spring.util;

import java.util.List;

public interface FileInterface<T> {
    List<T> readFromFile(String path);
    void saveAll(List<T> objs, String path);
}
