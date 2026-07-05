package com.shoptony.nyano.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "java_product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(255) ")
    private String productName;

    @Column(nullable = false, columnDefinition = "varchar(255) ")
    private BigDecimal productPrice;

    @Column(columnDefinition = "varchar(255) ")
    private String productDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "java_product_order",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )

    private List<OrderEntity> orderList;
}
