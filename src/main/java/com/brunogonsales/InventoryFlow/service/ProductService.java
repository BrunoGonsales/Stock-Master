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

    @Transactional
    public Product save (Product product) {
        if (product.getDescription() == null || product.getDescription().isEmpty()){
            throw new IllegalArgumentException("A descrição do produto não pode estar vazia");
        }
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto" + id + "não encontrado!"));
    }
}
