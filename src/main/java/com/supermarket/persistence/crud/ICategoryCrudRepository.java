package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryCrudRepository extends JpaRepository<Category, Long> {
}