package com.telecom.demo.serviceImpl;

import com.telecom.demo.controller.customer.dto.CustomerDTO;
import com.telecom.demo.db.entities.customer.Address;
import com.telecom.demo.db.entities.customer.Customer;
import com.telecom.demo.db.repo.customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService ;

    @Test
    void testGetAllCustomer() {
        List<Customer> mockedDBResponse= new ArrayList<>();
        Customer c1 = new Customer();
        c1.setPhoneNumber("123456789");
        c1.setName("abc");
        c1.setIsActive(true);
        Address a1 =  new Address();
        a1.setCustomer(c1);
        a1.setCity("HYD");
        a1.setCountry("IND");
        a1.setZipCode(12345);

        c1.setAddress(a1);
        mockedDBResponse.add(c1);

        Mockito.when(customerRepository.findAll()).thenReturn(mockedDBResponse);
        List<CustomerDTO> responseFromService = customerService.getAllCustomer();

        assertNotNull(responseFromService);
        assertEquals(responseFromService.get(0).getName(),c1.getName());




    }


}
