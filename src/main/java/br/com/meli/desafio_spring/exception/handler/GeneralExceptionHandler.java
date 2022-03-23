package br.com.meli.desafio_spring.exception.handler;

import br.com.meli.desafio_spring.exception.ProductAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GeneralExceptionHandler {
    @ExceptionHandler(value = ProductAlreadyExistsException.class)
    protected ResponseEntity<Object> handleProductAlreadyExistsException(ProductAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }
}
