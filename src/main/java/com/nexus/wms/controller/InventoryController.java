package com.nexus.wms.controller;

import com.nexus.wms.model.InventoryItem;
import com.nexus.wms.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    @PostMapping
    public InventoryItem addItem(@RequestBody InventoryItem product) {
        if (product.getStatus() == null) {
            product.setStatus(InventoryItem.StockStatus.IN_STOCK);
        }
        return inventoryRepository.save(product);
    }
}