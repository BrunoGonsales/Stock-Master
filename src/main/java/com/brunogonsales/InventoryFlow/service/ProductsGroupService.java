package com.brunogonsales.InventoryFlow.service;

import com.brunogonsales.InventoryFlow.model.ProductsGroup;
import com.brunogonsales.InventoryFlow.repository.ProductsGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsGroupService {

    private final ProductsGroupRepository groupRepository;

    public ProductsGroup save (ProductsGroup group) {
        if (group.getDescription() == null || group.getDescription().isEmpty()){
            throw new IllegalArgumentException("A descrição do grupo não pode estar vazia");
        }
        return groupRepository.save(group);
    }

    public List<ProductsGroup> findAll(){
        return groupRepository.findAll();
    }

    public ProductsGroup findById(Long id){
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado com o código " + id));
    }
}
