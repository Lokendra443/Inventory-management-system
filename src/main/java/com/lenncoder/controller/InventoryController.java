package com.lenncoder.controller;

import com.lenncoder.entity.Inventory;
import com.lenncoder.response.ApiResponse;
import com.lenncoder.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/inventories")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<Inventory>> createInventory(@RequestBody Inventory inventory){
        Inventory createdInventory = inventoryService.createInventory(inventory);
        ApiResponse<Inventory> response = new ApiResponse<>("Inventory created successfully", createdInventory);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Inventory>> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory updatedInventory = inventoryService.updateInventory(id, inventory);
        ApiResponse<Inventory> response = new ApiResponse<>("Inventory updated successfully", updatedInventory);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        Optional<Inventory> inventory = inventoryService.getInventoryById(id);
        return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return ResponseEntity.ok(inventories);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }
}
