package com.telecom.demo.db.entities.product;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class PlanService {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


}
