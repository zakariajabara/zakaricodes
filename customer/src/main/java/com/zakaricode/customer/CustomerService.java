package com.zakaricode.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private final RestTemplate restTemplate;
    private final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request){
             Customer customer =  Customer.builder()
                     .name(request.name())
                     .email(request.email())
                     .build();
             log.info("-------------save");
             customerRepository.saveAndFlush(customer);
             log.info("save customer: "+ customer.getId());
             //todo: check if email valid
             //todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
             //todo: send notification
    }
}
