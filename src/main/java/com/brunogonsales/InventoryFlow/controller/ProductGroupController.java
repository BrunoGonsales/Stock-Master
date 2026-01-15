package com.brunogonsales.InventoryFlow.controller;

import com.brunogonsales.InventoryFlow.model.ProductGroup;
import com.brunogonsales.InventoryFlow.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class ProductGroupController {

    private final ProductGroupService groupService;

    //Cria o método POST
    @PostMapping
    public ResponseEntity<ProductGroup> create(@RequestBody ProductGroup group){
        ProductGroup savedGroup = groupService.save(group);
        return ResponseEntity.ok(savedGroup);
    }

    //Cria o método Listar Todos GET
    @GetMapping
    public ResponseEntity<List<ProductGroup>> getAll() {
        return ResponseEntity.ok(groupService.findAll());
    }

    //Cria o método Busca por ID GET
    @GetMapping("/{id}")
    public ResponseEntity<ProductGroup> getById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.findById(id));
    }
}
