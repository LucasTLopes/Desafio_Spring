package br.com.meli.desafio_spring.controller;

import br.com.meli.desafio_spring.dto.CartDTO;
import br.com.meli.desafio_spring.dto.CustomerDTO;
import br.com.meli.desafio_spring.entity.Customer;
import br.com.meli.desafio_spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/api/v1/insert-customer-request")
    public ResponseEntity <List<CustomerDTO>> list(@RequestBody List<Customer> customer) {
        return new ResponseEntity(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/customers")
    public ResponseEntity<List<CustomerDTO>> getCustomers(@RequestParam(name = "state", required=false) String state) {
        return new ResponseEntity(customerService.getCustomers(state), HttpStatus.OK);
    }
}
