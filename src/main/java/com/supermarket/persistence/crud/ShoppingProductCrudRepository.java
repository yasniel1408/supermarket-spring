package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.ShoppingProduct;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingProductCrudRepository extends CrudRepository<ShoppingProduct, Long> {
}