package com.brunogonsales.InventoryFlow.service;

import com.brunogonsales.InventoryFlow.model.Product;
import com.brunogonsales.InventoryFlow.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save (Product product) {
        if (productRepository.existsById(product.getId())){
            throw new RuntimeException("Já existe um produto cadastrado com esse ID");
        }
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
