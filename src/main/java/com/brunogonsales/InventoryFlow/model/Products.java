package com.brunogonsales.InventoryFlow.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "last_purchase_price", precision = 17, scale = 2)
    private BigDecimal lastPurchasePrice;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ProductsGroup groupId;

}
