package com.telecom.demo.db.entities.customer;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String addressLine1;

    @Column
    private String addressLine2;

    @Column
    private String addressLine3;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private int zipCode;

    @OneToOne(targetEntity = Customer.class,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn(name="customer_id")
    private Customer customer;


}
