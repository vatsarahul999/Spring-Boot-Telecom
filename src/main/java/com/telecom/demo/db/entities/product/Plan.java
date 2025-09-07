package com.telecom.demo.db.entities.product;

import com.telecom.demo.db.entities.order.Orders;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(targetEntity=Product.class, fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

}
