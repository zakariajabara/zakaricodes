package com.zakaricode.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request){
             Customer customer =  Customer.builder()
                     .name(request.name())
                     .email(request.email())
                     .build();
             //todo: check if email valid
             //todo: store customer
    }
}
