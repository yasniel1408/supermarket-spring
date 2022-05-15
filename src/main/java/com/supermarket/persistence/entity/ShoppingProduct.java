package com.supermarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shopping_product")
@Getter
@Setter
public class ShoppingProduct{

    /**
     * Shopping id
     */
    @EmbeddedId
    private ShoppingProductPK id;

    /**
     * Cant
     */
    private Integer cant;

    /**
     * Total
     */
    private Integer total;

    /**
     * State
     */
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_shopping", insertable = false, updatable = false)
    private Shopping shopping;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;
}
