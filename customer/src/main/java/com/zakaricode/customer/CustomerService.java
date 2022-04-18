package com.zakaricode.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request){
             Customer customer =  Customer.builder()
                     .name(request.name())
                     .email(request.email())
                     .build();
             customerRepository.save(customer);
             //todo: check if email valid
             //todo: store customer
    }
}
