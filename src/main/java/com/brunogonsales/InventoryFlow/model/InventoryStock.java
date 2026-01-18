package com.brunogonsales.InventoryFlow.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "inventory_stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InventoryStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("groupsId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnoreProperties("stock")
    private InventoryLocation location;

    @Column(precision = 15, scale = 3)
    private BigDecimal quantity;


}
