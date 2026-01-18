package com.brunogonsales.InventoryFlow.controller;

import com.brunogonsales.InventoryFlow.model.InventoryLocation;
import com.brunogonsales.InventoryFlow.service.InventoryLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class InventoryLocationController {
    private final InventoryLocationService locationService;

    @PostMapping
    public ResponseEntity<InventoryLocation> create(@RequestBody InventoryLocation inventoryLocation) {
        InventoryLocation savedLocation = locationService.save(inventoryLocation);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedLocation.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedLocation);
    }

    @GetMapping
    public ResponseEntity<List<InventoryLocation>> getAll(){
        return ResponseEntity.ok(locationService.findAll());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<InventoryLocation> getById(@PathVariable Long id){
        return ResponseEntity.ok(locationService.findById(id));
    }


}
