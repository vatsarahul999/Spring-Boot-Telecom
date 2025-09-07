package com.telecom.demo.db.repo.customer;

import com.telecom.demo.db.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
