package com.nexus.wms.controller;

import com.nexus.wms.model.InventoryItem;
import com.nexus.wms.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*") // Frontend connect panrathukku CORS allow pannirukku
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Ellaa products-ayum fetch panna
    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    // Pudhu product add panna
    @PostMapping
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryRepository.save(item);
    }

    // Product-ah ID muliama delete panna (Remove button click panrathukku)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}