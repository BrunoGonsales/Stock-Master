package com.brunogonsales.InventoryFlow.controller;

import com.brunogonsales.InventoryFlow.model.ProductGroup;
import com.brunogonsales.InventoryFlow.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        // Monta a URL: http://localhost:8080/api/groups/{id}
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()   // Pega a URL atual (/api/groups)
                .path("/{id}")          // Adiciona o ID do que foi criado
                .buildAndExpand(savedGroup.getId()) // Substitui o {id} pelo valor real
                .toUri();               // Transforma em objeto URI

        // Retorna o Status 201, o Header 'Location' e o objeto no Body
        return ResponseEntity.created(uri).body(savedGroup);
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
