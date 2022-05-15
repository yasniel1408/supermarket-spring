package com.supermarket.domain.repository;

import com.supermarket.persistence.entity.ShoppingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingProductRepository extends JpaRepository<ShoppingProduct, Long> {
}