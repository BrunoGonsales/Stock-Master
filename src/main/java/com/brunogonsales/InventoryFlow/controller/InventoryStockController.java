package com.brunogonsales.InventoryFlow.controller;

import com.brunogonsales.InventoryFlow.model.InventoryLocation;
import com.brunogonsales.InventoryFlow.model.InventoryStock;
import com.brunogonsales.InventoryFlow.model.Product;
import com.brunogonsales.InventoryFlow.service.InventoryLocationService;
import com.brunogonsales.InventoryFlow.service.InventoryStockService;
import com.brunogonsales.InventoryFlow.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class InventoryStockController {
    private final InventoryStockService stockService;
    private final ProductService productService;
    private final InventoryLocationService locationService;

    //Método para registrar entrada de estoque
    @PostMapping("/add")
    public ResponseEntity<InventoryStock> addStock(
            @RequestParam Long productId,
            @RequestParam Long locationId,
            @RequestParam BigDecimal quantity) {

        // 1. Busca os objetos no banco usando os IDs
        Product product = productService.findById(productId);
        InventoryLocation location = locationService.findById(locationId);

        // 2. Agora sim, passa os objetos completos para o seu Service
        InventoryStock updateStock = stockService.updateStock(product,location,quantity);

        return ResponseEntity.ok(updateStock);
    }

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> getBalance(
            @RequestParam Long productId,
            @RequestParam Long locationId) {

        Product product = productService.findById(productId);
        InventoryLocation location = locationService.findById(locationId);

        BigDecimal balance = stockService.getStockBalance(product,location);

        return ResponseEntity.ok(balance);
    }
}
