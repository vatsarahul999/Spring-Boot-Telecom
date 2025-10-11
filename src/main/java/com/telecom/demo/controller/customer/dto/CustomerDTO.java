package com.telecom.demo.controller.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String name;
    private String phoneNo;

}
