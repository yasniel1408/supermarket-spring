package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Long> {
}