package br.com.meli.desafio_spring.util;

import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.exception.FileAccessException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilePurchaseUtil implements FileInterface <Purchase> {

    @Override
    public List<Purchase> readFromFile(String path) {

        final ObjectMapper objectMapper = new ObjectMapper();
        List<Purchase> listObjects = new ArrayList<>();

        try {
            listObjects = objectMapper.readValue(new File(path),
                    new TypeReference<List<Purchase>>() {});
        } catch ( IOException ioException) {
            System.out.println(ioException);
        }

        return listObjects;
    }

    @Override
    public void saveAll(List<Purchase> list, String path) {

        List<Purchase> listAll = readFromFile(path);
        listAll.addAll(list);

        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), listAll);
        } catch (IOException e) {
            throw new FileAccessException("não foi possível realizar a leitura/escrita no arquivo base.");
        }
    }

}
