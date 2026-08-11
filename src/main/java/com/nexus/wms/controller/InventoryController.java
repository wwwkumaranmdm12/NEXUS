package com.nexus.wms.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.nexus.wms.model.InventoryItem;
import com.nexus.wms.repository.InventoryRepository;

@RestController
@RequestMapping("/api/v1/inventory")
@CrossOrigin(origins = "http://localhost:5173")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    // GET all products
    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    // POST new product
    @PostMapping
    public InventoryItem createItem(@RequestBody InventoryItem item) {
        return inventoryRepository.save(item);
    }

    // PUT update product
    @PutMapping("/{id}")
    public InventoryItem updateItem(@PathVariable Long id, @RequestBody InventoryItem itemDetails) {
        InventoryItem item = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));

        item.setSku(itemDetails.getSku());
        item.setName(itemDetails.getName());
        item.setCategory(itemDetails.getCategory());
        item.setZone(itemDetails.getZone());
        item.setPrice(itemDetails.getPrice());
        item.setStock(itemDetails.getStock());

        return inventoryRepository.save(item);
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
    }
}