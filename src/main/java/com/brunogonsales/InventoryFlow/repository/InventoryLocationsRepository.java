package com.brunogonsales.InventoryFlow.repository;

import com.brunogonsales.InventoryFlow.model.InventoryLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryLocationsRepository extends JpaRepository<InventoryLocations,Long> {
}
