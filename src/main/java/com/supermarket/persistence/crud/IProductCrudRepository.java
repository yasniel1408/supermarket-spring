package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends JpaRepository<Product, Long> {

    /**
     * Example Query Method findByCategoryIdOrderByNameAsc
     * @param categoryId category id
     * @return product list
     */
    List<Product> findByCategoryIdOrderByNameAsc(Long categoryId);


    /**
     * Example Query Native findByCategoryIdOrderByNameAsc
     * @param categoryId category id
     * @return product list
     */
    @Query(value = "select * from Product where categoryId = ?", nativeQuery = true)
    List<Product> getByCategoryIdOrderByNameAsc2(Long categoryId);


    /**
     *  Example Query Method findByCantStockLessThanAndState
     * @param cantStock cant in stock
     * @param state product state
     * @return Optional product list
     */
    Optional<List<Product>> findByCantStockLessThanAndState(int cantStock, boolean state);

}