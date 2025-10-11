package com.telecom.demo.db.repo.customer;

import com.telecom.demo.db.entities.customer.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    public List<Address> findByZipCode(int zipcode);

    public List<Address> findByCity(String city);

    public List<Address> findByCityAndCountry(String city, String country);

    public List<Address> findByCityOrCountry(String city, String country);


}
