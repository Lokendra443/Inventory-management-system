package com.lenncoder.service.impl;

import com.lenncoder.entity.Inventory;
import com.lenncoder.repository.InventoryRepository;
import com.lenncoder.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public Inventory createInventory(Inventory inventory) {
        inventory.setTotalAmount(inventory.getAmountPerPiece() * inventory.getTotalQuantity());
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory updateInventory(Long id, Inventory inventory) {
        return inventoryRepository.findById(id).map(existingInventory -> {
            existingInventory.setName(inventory.getName());
            existingInventory.setTotalQuantity(inventory.getTotalQuantity());
            existingInventory.setAmountPerPiece(inventory.getAmountPerPiece());
            existingInventory.setTotalAmount(inventory.getAmountPerPiece() * inventory.getTotalQuantity());
            existingInventory.setUpdatedBy(inventory.getUpdatedBy());
            return inventoryRepository.save(existingInventory);
        }).orElseThrow(() -> new RuntimeException("Inventory not found with id: "+id));
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);

    }

}
