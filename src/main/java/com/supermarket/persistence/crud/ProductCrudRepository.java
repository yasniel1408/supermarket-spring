package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {
}