package com.supermarket.domain.service;

import com.supermarket.domain.dto.ProductDto;
import com.supermarket.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;


    public List<ProductDto> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Optional<List<ProductDto>> getAllProductsByCategory(Long categoryId) {
        return productRepository.getAllProductsByCategory(categoryId);
    }

    public Optional<List<ProductDto>> getActiveProductScarce(int cant) {
        return productRepository.getActiveProductScarce(cant);
    }

    public Optional<ProductDto> getOneProduct(Long productId) {
        return productRepository.getOneProduct(productId);
    }

    public ProductDto saveProduct(ProductDto productDto) {
        return productRepository.saveProduct(productDto);
    }

    public boolean deleteProduct(Long productId) {
        return getOneProduct(productId).map(prod -> {
            productRepository.deleteProduct(productId);
            return true;
        }).orElse(false);
    }

}
