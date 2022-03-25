package br.com.meli.desafio_spring.service;

import br.com.meli.desafio_spring.dto.ArticlePurchaseDTO;
import br.com.meli.desafio_spring.dto.CustomerDTO;
import br.com.meli.desafio_spring.entity.Article;
import br.com.meli.desafio_spring.entity.Customer;
import br.com.meli.desafio_spring.entity.Purchase;
import br.com.meli.desafio_spring.exception.BadRequestException;
import br.com.meli.desafio_spring.repository.implementations.CustomerRepository;
import br.com.meli.desafio_spring.repository.implementations.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> saveCustomer(List <Customer> customers){

        List<CustomerDTO> customerList = new ArrayList<>();


        checkOperation(customers);

        return customerRepository.saveAll(customers).stream().map(CustomerDTO::convert).collect(Collectors.toList());

    }

    public void checkOperation(List <Customer> customers){
        List <Long> listIdsError = new ArrayList<>();
        List <String> messageError = new ArrayList<>();

        if (customers.isEmpty()) {
            throw new BadRequestException("Requisição invalida");
        }

        for (Customer a:customers) {

            if(customerRepository.findById(a.getId()).isPresent()){
                listIdsError.add(a.getId());
                messageError.add(" ID: " + a.getId() + " já cadastrado; ");
            }
            else if (a.getId() == null || a.getName() == null || a.getState() == null || a.getCpf() == null){
                listIdsError.add(a.getId());
                messageError.add("campos incompletos para o cliente: "+ a.toString());
            }
        }
        if (!listIdsError.isEmpty())
            throw new BadRequestException(messageError.toString());
    }

    public List<CustomerDTO> getCustomers(String state) {
        if(state == null) return customerRepository.list().stream().map(CustomerDTO::convert).collect(Collectors.toList());
        return customerRepository.list().stream().filter(customer -> customer.getState().equalsIgnoreCase(state)).map(CustomerDTO::convert).collect(Collectors.toList());
    }
}
