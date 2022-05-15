package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    List<Product> findByCategoryId(int categoryId);
}