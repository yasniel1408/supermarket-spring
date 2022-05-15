package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Shopping;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCrudRepository extends CrudRepository<Shopping, Long> {
}