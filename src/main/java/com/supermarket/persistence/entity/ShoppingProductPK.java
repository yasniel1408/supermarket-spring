package com.supermarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ShoppingProductPK implements Serializable {

    /**
     * Shopping id
     */
    @Column(name = "id_shopping")
    private Long shoppingId;

    /**
     * Product id
     */
    @Column(name = "id_product")
    private Long productId;
}
