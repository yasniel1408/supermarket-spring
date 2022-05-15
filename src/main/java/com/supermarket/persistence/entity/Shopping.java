package com.supermarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping")
@Getter
@Setter
public class Shopping extends BaseEntity{

    /**
     * Payment method
     */
    @Column(name = "payment_method")
    private String paymentMethod;

    /**
     * Comment
     */
    private String comment;

    /**
     * State
     */
    private Boolean state;

    /**
     * Client
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "shopping")
    private List<ShoppingProduct> shoppingProducts;

}
