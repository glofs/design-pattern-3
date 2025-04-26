package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.proxy.CustomerOperationsProxy;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerOperationsProxy proxy;

    public CustomerService(ICustomerRepository customerRepository, CustomerOperationsProxy proxy) {
        this.proxy = proxy;
    }

    public Customer createCustomer(CustomerDTO customerDTO) {
        // Implementar proxy para verificar que el correo no sea del dominio yahoo
        return proxy.create(customerDTO);
    }
}
