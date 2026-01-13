package com.brunogonsales.InventoryFlow.controller;

import com.brunogonsales.InventoryFlow.model.ProductsGroup;
import com.brunogonsales.InventoryFlow.service.ProductsGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class ProductGroupController {

    private final ProductsGroupService groupService;

    public ResponseEntity<ProductsGroup> create(@RequestBody ProductsGroup group){
        ProductsGroup savedGroup = groupService.save(group);
        return ResponseEntity.ok(savedGroup);
    }

    @GetMapping
    public ResponseEntity<List<ProductsGroup>> getAll() {
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsGroup> getById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.findById(id));
    }
}
