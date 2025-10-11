package com.telecom.demo.service;

import com.telecom.demo.controller.customer.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    public CustomerDTO createCustomer(CustomerDTO customerDTO);

    public List<CustomerDTO> getAllCustomer();

    List<CustomerDTO> getAllCustomerInCity(String city);
}
