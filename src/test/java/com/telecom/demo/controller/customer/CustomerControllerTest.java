package com.telecom.demo.controller.customer;

import com.telecom.demo.controller.customer.dto.CustomerDTO;
import com.telecom.demo.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllCustomer() throws Exception {
        CustomerDTO mockedResponse = new CustomerDTO();
        mockedResponse.setZipcode("12345");
        mockedResponse.setCity("HYD");
        mockedResponse.setCountry("IND");
        mockedResponse.setName("abc");
        mockedResponse.setPhoneNo("123456789");
        List<CustomerDTO> responseMocked = new ArrayList<>();
        responseMocked.add(mockedResponse);
        Mockito.when(customerService.getAllCustomer()).thenReturn(responseMocked);
        mockMvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(mockedResponse.getName()));
        //[CustomerDTO(address=null null null, zipcode=12345, city=HYD, country=IND, name=abc, phoneNo=123456789)]
    }
}
