package com.lenncoder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer totalQuantity;
    // Precision specifies total digits, and scale specifies digits after the decimal point
    //@Column(precision = 10, scale = 4)
    private double amountPerPiece;
    //@Column(precision = 15, scale = 4)
    private double totalAmount;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    private Long updatedBy; // User ID of the person who updated the record
}
