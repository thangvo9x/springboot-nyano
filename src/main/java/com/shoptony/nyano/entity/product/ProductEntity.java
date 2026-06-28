package com.shoptony.nyano.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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

    @Column(nullable = false, columnDefinition = "varchar(255) ")
    private String productDescription;

    @Column(nullable = false, columnDefinition = "varchar(255) ")
    private String productImage;

    @Column(nullable = false, columnDefinition = "varchar(255) ")
    private String productCategory;
}
