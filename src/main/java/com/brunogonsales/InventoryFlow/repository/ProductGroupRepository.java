package com.brunogonsales.InventoryFlow.repository;

import com.brunogonsales.InventoryFlow.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {
    Optional<ProductGroup> findById(Integer code);
}
