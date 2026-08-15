package com.nexus.wms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "inventory_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String category;

    private String zone;

    @Column(nullable = true)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Enumerated(EnumType.STRING)
    private StockStatus status;

    public enum StockStatus {
        IN_STOCK,
        LOW_STOCK,
        OUT_OF_STOCK
    }
}