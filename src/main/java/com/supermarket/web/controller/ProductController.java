package com.supermarket.web.controller;

import com.supermarket.domain.dto.ProductDto;
import com.supermarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<ProductDto>> getAllProductsByCategory(@PathVariable("categoryId") Long categoryId) {
        return productService.getAllProductsByCategory(categoryId);
    }

    @GetMapping("/{productId}")
    public Optional<ProductDto> getOneProduct(@PathVariable("productId") Long productId) {
        return productService.getOneProduct(productId);
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable("productId") Long productId) {
        return productService.deleteProduct(productId);
    }

}
