package com.supermarket.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "category")
@Getter
@Setter
public class Category extends BaseAnonymousEntity{

    /**
     * Description
     */
    private String description;

    /**
     * State
     */
    private Boolean state;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

}
