package com.telecom.demo.db.entities.order;

import com.telecom.demo.db.entities.customer.Customer;
import com.telecom.demo.db.entities.product.PlanService;
import com.telecom.demo.db.entities.product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name="customer_id")
    @ManyToOne
    private Customer customer;

    @JoinColumn(name="product_id")
    @ManyToOne
    private Product product;

    @JoinColumn(name="plan_service_id")
    @ManyToOne
    private PlanService planService;
}
