package com.supermarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends BaseAnonymousEntity {

    /**
     * Name
     */
    private String name;

    /**
     * Bar Code
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * Sale price
     */
    @Column(name = "sale_price")
    private Double salePrice;

    /**
     * Cantidad en stock
     */
    @Column(name = "cant_stock")
    private Integer cantStock;

    /**
     * State
     */
    private Boolean state;

    /**
     * Category id
     */
    @Column(name = "id_category")
    private Long categoryId;

    /**
     * Client
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private Category category;


}
