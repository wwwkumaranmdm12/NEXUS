package com.nexus.wms.service;

import com.nexus.wms.model.InventoryItem;
import com.nexus.wms.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    public InventoryItem saveItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }
}