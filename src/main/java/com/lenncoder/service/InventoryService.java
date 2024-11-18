package com.lenncoder.service;

import com.lenncoder.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    Inventory createInventory(Inventory inventory);
    Optional<Inventory> getInventoryById(Long id);
    List<Inventory> getAllInventories();
    Inventory updateInventory(Long id, Inventory inventory);
    void deleteInventory(Long id);
}
