package com.lenncoder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name", nullable=false, length=50)
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Employee employee;
}
