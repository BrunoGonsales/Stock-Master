package com.brunogonsales.InventoryFlow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products_group")
@Getter
@Setter
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
