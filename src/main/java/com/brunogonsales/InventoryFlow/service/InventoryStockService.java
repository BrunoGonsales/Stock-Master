package com.brunogonsales.InventoryFlow.service;

import com.brunogonsales.InventoryFlow.model.InventoryLocations;
import com.brunogonsales.InventoryFlow.model.InventoryStock;
import com.brunogonsales.InventoryFlow.model.Products;
import com.brunogonsales.InventoryFlow.repository.InventoryStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryStockService {
    private final InventoryStockRepository stockRepository;

    @Transactional
    public InventoryStock updateStock(Products product, InventoryLocations location, BigDecimal quantity){
        // 1. Tenta encontrar se já existe esse produto nesse local
        Optional<InventoryStock> existingStock = stockRepository.findByProductAndLocation(product, location);

        if (existingStock.isPresent()) {
            // 2. Se existe, soma a nova quantidade à atual
            InventoryStock stock = existingStock.get();
            stock.setQuantity(stock.getQuantity().add(quantity));
            return stockRepository.save(stock);
        } else {
            // 3. Se não existe, cria um registro novo
            InventoryStock newStock = new InventoryStock();
            newStock.setProducts(product);
            newStock.setLocation(location);
            newStock.setQuantity(quantity);
            return stockRepository.save(newStock);
        }
    }
}
