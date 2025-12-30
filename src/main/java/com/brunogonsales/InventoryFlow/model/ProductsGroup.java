package com.brunogonsales.InventoryFlow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductsGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column (nullable = false,unique = true)
    private Integer code;

    @Column (nullable = false)
    private String description;

    @OneToMany(mappedBy = "groupId")
    private List<Products> products;
}
