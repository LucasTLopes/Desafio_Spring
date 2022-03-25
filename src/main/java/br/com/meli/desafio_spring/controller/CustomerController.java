package br.com.meli.desafio_spring.controller;

import br.com.meli.desafio_spring.dto.CartDTO;
import br.com.meli.desafio_spring.dto.CustomerDTO;
import br.com.meli.desafio_spring.entity.Customer;
import br.com.meli.desafio_spring.service.CustomerService;
import br.com.meli.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe controlador responsável por lidar com as rotas referentes ao recurso customer.
 * Possui rotas para a criação  e listagem de clientes
 * @author Jederson Macedo
 * @author Igor Nogueira
 * @author Lucas Troleiz
 */
@RestController
public class CustomerController {
    /**
     * {@link CustomerService Service} de customer injetado
     */
    @Autowired
    private CustomerService customerService;

    /**
     * Endpoint responsável pela criação dos customers
     *
     * @param customer
     * @return
     */
    @PostMapping("/api/v1/insert-customer-request")
    public ResponseEntity <List<CustomerDTO>> list(@RequestBody List<Customer> customer) {
        return new ResponseEntity(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    /**
     * Endpoint responsável pela listagem dos customers.
     *
     * @param state
     * @return
     */
    @GetMapping("/api/v1/customers")
    public ResponseEntity<List<CustomerDTO>> getCustomers(@RequestParam(name = "state", required=false) String state) {
        return new ResponseEntity(customerService.getCustomers(state), HttpStatus.OK);
    }
}
