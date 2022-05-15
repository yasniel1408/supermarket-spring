package com.supermarket.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProductDto implements Serializable {
    private final Long id;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;
    private final Long version;
    private final String name;
    private final String barCode;
    private final Double salePrice;
    private final Integer cantStock;
    private final Boolean state;
}
