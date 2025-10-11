package com.telecom.demo.serviceImpl;

import com.telecom.demo.controller.customer.dto.CustomerDTO;
import com.telecom.demo.db.entities.customer.Address;
import com.telecom.demo.db.entities.customer.Customer;
import com.telecom.demo.db.repo.customer.AddressRepository;
import com.telecom.demo.db.repo.customer.CustomerRepository;
import com.telecom.demo.service.CustomerService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = getCustomer(customerDTO);
        addressRepository.save(customer.getAddress());
        customerRepository.save(customer);
        return getCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> result =convertCustomerToCustomerDTO(customers);
        return result;
    }

    @Override
    public List<CustomerDTO> getAllCustomerInCity(String city) {
        List<Address> allAddress = addressRepository.findByCity(city);
        if(CollectionUtils.isNotEmpty(allAddress)) {
            List<Customer> allCustomers = new ArrayList<>();
            for (Address address : allAddress) {
                allCustomers.add(address.getCustomer());
            }
            return convertCustomerToCustomerDTO(allCustomers);
        }
        return List.of();
    }

    public List<CustomerDTO> convertCustomerToCustomerDTO(List<Customer> customers) {
        List<CustomerDTO> result = new ArrayList<>();
        for (Customer cust: customers) {
            CustomerDTO customerDTO = getCustomerDTO(cust);
            result.add(customerDTO);
        }
        return result;
    }

    private  Customer getCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        Address address = new Address();
        int len1 = Math.min(customerDTO.getAddress().length(), 50);
        String addLine1 = customerDTO.getAddress().substring(0,len1);
        int len2 = Math.min(customerDTO.getAddress().length(), 100);
        String addLine2 = len1 == 50 ? customerDTO.getAddress().substring(50,len2) : null;
        int len3 = Math.min(customerDTO.getAddress().length(), 150);
        String addLine3 = len2 == 100 ? customerDTO.getAddress().substring(100,len3) : null;

        address.setAddressLine1(addLine1);
        address.setAddressLine2(addLine2);
        address.setAddressLine3(addLine3);
        address.setCity(customerDTO.getCity());
        address.setCountry(customerDTO.getCountry());
        address.setZipCode(Integer.parseInt(customerDTO.getZipcode()));
        address.setCustomer(customer);
        customer.setName(customerDTO.getName());
        customer.setAddress(address);
        customer.setPhoneNumber(customerDTO.getPhoneNo());
        return customer;
    }

    private CustomerDTO getCustomerDTO(Customer cust) {
        CustomerDTO customerDTO = new CustomerDTO();
        if(cust.getAddress()!= null) {
            customerDTO.setAddress(cust.getAddress().getAddressLine1() + " " + cust.getAddress().getAddressLine2() + " " + cust.getAddress().getAddressLine3());
            customerDTO.setCity(cust.getAddress().getCity());
            customerDTO.setCountry(cust.getAddress().getCountry());
            customerDTO.setZipcode(Integer.toString(cust.getAddress().getZipCode()));
        }
        customerDTO.setName(cust.getName());
        customerDTO.setPhoneNo(cust.getPhoneNumber());
        return customerDTO;
    }
}
