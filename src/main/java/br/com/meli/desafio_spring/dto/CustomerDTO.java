package br.com.meli.desafio_spring.dto;

import br.com.meli.desafio_spring.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String state;

    public static CustomerDTO convert(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getState());
    }
}
