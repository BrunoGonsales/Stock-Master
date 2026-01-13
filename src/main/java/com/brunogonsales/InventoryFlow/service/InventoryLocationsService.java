package com.brunogonsales.InventoryFlow.service;

import com.brunogonsales.InventoryFlow.model.InventoryLocations;
import com.brunogonsales.InventoryFlow.repository.InventoryLocationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryLocationsService {

    private final InventoryLocationsRepository locationRepository;

    public InventoryLocations save (InventoryLocations locations){
        return locationRepository.save(locations);
    }

    public List<InventoryLocations> findAll(){
        return locationRepository.findAll();
    }

    public InventoryLocations findById(Long id){
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado. O estoque " + id + " não existe."));
    }
}
