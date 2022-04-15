package com.zakaricode.customer;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;

@Builder
@Data
public class Customer {

    @Id
    @Gene
    private Integer id;
    private String name;
    private String email;

}
