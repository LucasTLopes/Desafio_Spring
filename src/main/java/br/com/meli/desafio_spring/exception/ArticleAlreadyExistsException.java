package br.com.meli.desafio_spring.exception;

public class ArticleAlreadyExistsException extends RuntimeException {
    public ArticleAlreadyExistsException(String message) {
        super(message);
    }
}
