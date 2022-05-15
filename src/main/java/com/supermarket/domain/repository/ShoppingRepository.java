package com.supermarket.domain.repository;

import com.supermarket.persistence.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
}