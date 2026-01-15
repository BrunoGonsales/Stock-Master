package com.brunogonsales.InventoryFlow.repository;

import com.brunogonsales.InventoryFlow.model.InventoryLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryLocationRepository extends JpaRepository<InventoryLocation,Long> {
}
