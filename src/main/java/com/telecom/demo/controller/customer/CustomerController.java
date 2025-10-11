package com.telecom.demo.controller.customer;

import com.telecom.demo.controller.customer.dto.CustomerDTO;
import com.telecom.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody  CustomerDTO request) {
        return customerService.createCustomer(request);
    }
    @GetMapping("/find/{city}")
    List<CustomerDTO> getAllCustomerInCity(@RequestParam String city){
        return customerService.getAllCustomerInCity(city);
    }
}
