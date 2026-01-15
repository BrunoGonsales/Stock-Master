package com.brunogonsales.InventoryFlow.service;

import com.brunogonsales.InventoryFlow.model.InventoryLocation;
import com.brunogonsales.InventoryFlow.repository.InventoryLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryLocationService {

    private final InventoryLocationRepository locationRepository;

    public InventoryLocation save (InventoryLocation locations){
        return locationRepository.save(locations);
    }

    public List<InventoryLocation> findAll(){
        return locationRepository.findAll();
    }

    public InventoryLocation findById(Long id){
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado. O estoque " + id + " não existe."));
    }
}
