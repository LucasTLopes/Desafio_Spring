package br.com.meli.desafio_spring.repository.implementations;

import br.com.meli.desafio_spring.entity.Customer;
import br.com.meli.desafio_spring.repository.Repository;
import br.com.meli.desafio_spring.util.FileCustomerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class CustomerRepository implements Repository<Customer> {
    private final String customersFileJson = "src/main/resources/customers.json";

    private final FileCustomerUtil fileUtil = new FileCustomerUtil();

    private List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        customers.addAll(fileUtil.readFromFile(customersFileJson));
    }

    public Optional<Customer> findById (Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findAny();
    }

    @Override
    public List<Customer> saveAll(List<Customer> list) {
        customers.addAll(list);
        fileUtil.saveAll(customers, customersFileJson);
        return list;
    }

    public List<Customer> list() {
        return customers;
    }
}
