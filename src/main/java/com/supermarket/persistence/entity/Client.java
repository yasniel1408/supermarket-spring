package com.supermarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
@Getter
@Setter
public class Client extends BaseAnonymousEntity{

    /**
     * Name
     */
    private String name;

    /**
     * Last name
     */
    @Column(name="last_name")
    private String lastName;

    /**
     * Phone number
     */
    private String phone;

    /**
     * Address
     */
    private String address;

    /**
     * Email
     */
    private String email;

    /**
     * Shopping
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Shopping> shoppings;

}
