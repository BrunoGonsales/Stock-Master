package com.brunogonsales.InventoryFlow.service;

import com.brunogonsales.InventoryFlow.model.Products;
import com.brunogonsales.InventoryFlow.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepository productsRepository;

    public Products save (Products products) {
        if (productsRepository.existsById(products.getId())){
            throw new RuntimeException("Já existe um produto cadastrado com esse ID");
        }
        return productsRepository.save(products);
    }

    @Transactional(readOnly = true)
    public List<Products> findAll(){
        return productsRepository.findAll();
    }
}
