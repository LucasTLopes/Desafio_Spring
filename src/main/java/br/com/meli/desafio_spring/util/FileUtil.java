package br.com.meli.desafio_spring.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static List<Object> readFromFile(String path) {

        final ObjectMapper objectMapper = new ObjectMapper();
        List<Object> listObjects = new ArrayList<>();

        try {
            listObjects = objectMapper.readValue(new File(path),
                    new TypeReference<List<Object>>() {});
        } catch ( IOException ioException) {
            System.out.println(ioException);
        }

        return listObjects;
    }

    public static void saveAll(List<?> list, String path) {

        List<Object> listAll = readFromFile(path);
        listAll.addAll(list);

        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), listAll);
        } catch ( IOException e) {
            System.out.println(e);
        }

    }
}
