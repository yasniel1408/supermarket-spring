package com.supermarket.domain.dto;

import com.supermarket.persistence.entity.ShoppingProductPK;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShoppingProductDto implements Serializable {
    private final ShoppingProductPK id;
    private final Integer cant;
    private final Integer total;
    private final Boolean state;
}
