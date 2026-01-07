package com.brunogonsales.InventoryFlow.repository;

import com.brunogonsales.InventoryFlow.model.InventoryStock;
import com.brunogonsales.InventoryFlow.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryStockRepository extends JpaRepository<InventoryStock,Long> {
    Optional<InventoryStock> findByProuctAndLocation(Products product,InventoryStock location);
    List<InventoryStock> findByProductId(Integer productId);
}
