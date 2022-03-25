package br.com.meli.desafio_spring.util;

import br.com.meli.desafio_spring.entity.Customer;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.exception.FileAccessException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCustomerUtil implements FileInterface<Customer>{
    @Override
    public List<Customer> readFromFile(String path) {

        final ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> listObjects = new ArrayList<>();

        try {
            listObjects = objectMapper.readValue(new File(path),
                    new TypeReference<List<Customer>>() {});
        } catch ( IOException ioException) {
            System.out.println(ioException);
        }

        return listObjects;
    }

    @Override
    public void saveAll(List<Customer> list, String path) {

        List<Customer> listAll = readFromFile(path);
        listAll.addAll(list);

        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), listAll);
        } catch (IOException e) {
            throw new FileAccessException("não foi possível realizar a leitura/escrita no arquivo base.");
        }
    }
}
