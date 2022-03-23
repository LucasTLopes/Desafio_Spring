package br.com.meli.desafio_spring.exception.handler;

import br.com.meli.desafio_spring.exception.ArticleAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GeneralExceptionHandler {
    @ExceptionHandler(value = ArticleAlreadyExistsException.class)
    protected ResponseEntity<Object> handleProductAlreadyExistsException(ArticleAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }
}
