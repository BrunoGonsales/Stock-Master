package com.brunogonsales.InventoryFlow.service;

import com.brunogonsales.InventoryFlow.model.ProductGroup;
import com.brunogonsales.InventoryFlow.repository.ProductGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGroupService {

    private final ProductGroupRepository groupRepository;

    public ProductGroup save (ProductGroup group) {
        if (group.getDescription() == null || group.getDescription().isEmpty()){
            throw new IllegalArgumentException("A descrição do grupo não pode estar vazia");
        }
        return groupRepository.save(group);
    }

    public List<ProductGroup> findAll(){
        return groupRepository.findAll();
    }

    public ProductGroup findById(Long id){
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado com o código " + id));
    }
}
