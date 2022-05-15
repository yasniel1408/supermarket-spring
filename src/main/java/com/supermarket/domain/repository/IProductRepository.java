package com.supermarket.domain.repository;


import com.supermarket.domain.dto.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository {

    List<ProductDto> getAllProducts();

    Optional<List<ProductDto>> getAllProductsByCategory(Long categoriaId);

    Optional<List<ProductDto>> getActiveProductScarce(int cant);

    Optional<ProductDto> getOneProduct(Long productId);

    ProductDto saveProduct(ProductDto product);

    void deleteProduct(Long productId);

}