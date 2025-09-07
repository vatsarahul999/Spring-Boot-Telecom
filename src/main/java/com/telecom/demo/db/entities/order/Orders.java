package com.telecom.demo.db.entities.order;

import com.telecom.demo.db.entities.customer.Customer;
import com.telecom.demo.db.entities.product.Plan;
import com.telecom.demo.db.entities.product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name="customer_id")
    @ManyToOne( fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name="product_id")
    @ManyToOne( fetch = FetchType.LAZY)
    private Product product;

    @JoinColumn(name="plan_id")
    @ManyToOne( fetch = FetchType.LAZY)
    private Plan plan;

}
