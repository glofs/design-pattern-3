package com.example.patterns_banking.services.proxy;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.ICustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerOperationsProxy implements ICustomerOperations {
    private ICustomerRepository customerRepository;

    public CustomerOperationsProxy(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(CustomerDTO customerDTO) {
        validateDomainEmail(customerDTO.getEmail());//agregamos validación en el proxy
        Customer customer = Customer
                .builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .build();
        return customerRepository.save(customer);
    }

    private void validateDomainEmail(String email) {
        if (email.contains("@yahoo")) {
            throw new IllegalArgumentException("the email using to create this user is not valid");
        }
    }
}
