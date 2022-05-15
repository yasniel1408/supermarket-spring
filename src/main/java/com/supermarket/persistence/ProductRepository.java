package com.supermarket.persistence;


import com.supermarket.persistence.crud.ProductCrudRepository;
import com.supermarket.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(Long categoriaId) {
        return productCrudRepository.findByCategoryIdOrderByNameAsc(categoriaId);
    }

    public Optional<List<Product>> getActiveProductScarce(int cant) {
        return productCrudRepository.findByCantStockLessThanAndState(cant, true);
    }

    public Optional<Product> getOneProduct(Long productId) {
        return productCrudRepository.findById(productId);
    }

    public Product saveProduct(Product product) {
        return productCrudRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productCrudRepository.deleteById(productId);
    }
}