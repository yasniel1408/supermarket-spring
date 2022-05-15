package com.supermarket.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ShoppingDto implements Serializable {
    private final Long id;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;
    private final Long version;
    private final String createdBy;
    private final String lastModifiedBy;
    private final String paymentMethod;
    private final String comment;
    private final Boolean state;
    private final ClientDto client;
}
