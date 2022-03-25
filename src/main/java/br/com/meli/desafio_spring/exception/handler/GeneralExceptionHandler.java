package br.com.meli.desafio_spring.exception.handler;

import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.exception.FileAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe ExceptionHandler responsável por lidar com as exceções abaixo listadas
 * @author Luis Felipe Olimpio
 * @author Arthur Guedes
 * @author Jeferson Barbosa
 */
@RestControllerAdvice
public class GeneralExceptionHandler {
    /**
     * Exceção responsável por tratar casos de bad request, retornando status code 400
     *
     * @param ex    Exceção a ser lançada
     * @return      ResponseEntity com status code necessário
     */
    @ExceptionHandler(value = BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }

    /**
     *  Exceção responsável por tratar casos de erro na leitura/escrita de arquivos, retornando status code 500
     *
     * @param ex    Exceção a ser lançada
     * @return      ResponseEntity com status code necessário
     */
    @ExceptionHandler(value = FileAccessException.class)
    protected ResponseEntity<Object> handleFileAccessException(FileAccessException ex) {
        return ResponseEntity.internalServerError().body("Error: " + ex.getMessage());
    }
}
