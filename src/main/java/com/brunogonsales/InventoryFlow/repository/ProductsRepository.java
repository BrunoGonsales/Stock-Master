package com.brunogonsales.InventoryFlow.repository;

import com.brunogonsales.InventoryFlow.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    List<Products> findByNameContainingIgnoreCase(String name);
}
