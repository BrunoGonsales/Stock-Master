package com.brunogonsales.InventoryFlow.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Products products;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private InventoryLocations location;

    @Column(precision = 15, scale = 3)
    private double quantity;


}
