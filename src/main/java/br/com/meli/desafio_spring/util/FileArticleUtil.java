package br.com.meli.desafio_spring.util;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.exception.FileAccessException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileArticleUtil implements FileInterface<Article> {

    public List<Article> readFromFile(String path) {

        final ObjectMapper objectMapper = new ObjectMapper();
        List<Article> listObjects = new ArrayList<>();

        try {
            listObjects = objectMapper.readValue(new File(path),
                    new TypeReference<List<Article>>() {});
        } catch ( IOException ioException) {
            System.out.println(ioException);
        }

        return listObjects;
    }

    public void saveAll(List<Article> list, String path) {

        List<Article> listAll = readFromFile(path);
        listAll.addAll(list);

        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), listAll);
        } catch (IOException e) {
            throw new FileAccessException("não foi possível realizar a leitura/escrita no arquivo base.");
        }

    }
}
