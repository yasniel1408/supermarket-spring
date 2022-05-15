package com.supermarket.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;
    private final Long version;
    private final String description;
    private final Boolean state;
}
