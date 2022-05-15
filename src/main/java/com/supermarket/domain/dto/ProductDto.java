package com.supermarket.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String name;
    private String barCode;
    private Double salePrice;
    private Integer cantStock;
    private Boolean state;
    private Long categoryId;
}
