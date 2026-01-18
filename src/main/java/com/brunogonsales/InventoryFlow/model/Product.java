package com.brunogonsales.InventoryFlow.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "last_purchase_price", precision = 17, scale = 2,nullable = true)
    private BigDecimal lastPurchasePrice;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true)
    @JsonIgnoreProperties("product")
    private ProductGroup groupId;

}
