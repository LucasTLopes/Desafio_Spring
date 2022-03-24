package br.com.meli.desafio_spring.exception;

public class FileAccessException extends RuntimeException {
    public FileAccessException(String message) {
        super(message);
    }
}
