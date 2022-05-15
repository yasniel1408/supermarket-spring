package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.ShoppingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingProductCrudRepository extends JpaRepository<ShoppingProduct, Long> {
}