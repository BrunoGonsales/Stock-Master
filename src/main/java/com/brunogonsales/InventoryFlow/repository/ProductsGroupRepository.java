package com.brunogonsales.InventoryFlow.repository;

import com.brunogonsales.InventoryFlow.model.ProductsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsGroupRepository extends JpaRepository<ProductsGroup,Integer> {
    Optional<ProductsGroup> findById(Integer code);
}
