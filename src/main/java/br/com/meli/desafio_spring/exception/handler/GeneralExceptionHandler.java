package br.com.meli.desafio_spring.exception.handler;

import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.exception.FileAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(value = BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }

    @ExceptionHandler(value = FileAccessException.class)
    protected ResponseEntity<Object> handleFileAccessException(FileAccessException ex) {
        return ResponseEntity.internalServerError().body("Error: " + ex.getMessage());
    }
}
