package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCrudRepository extends JpaRepository<Shopping, Long> {
}