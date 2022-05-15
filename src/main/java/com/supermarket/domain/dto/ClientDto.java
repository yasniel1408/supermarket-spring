package com.supermarket.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ClientDto implements Serializable {
    private final Long id;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;
    private final Long version;
    private final String name;
    private final String lastName;
    private final String phone;
    private final String address;
    private final String email;
    private final Set<ShoppingDto> shoppings;
}
