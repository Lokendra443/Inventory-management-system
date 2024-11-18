package com.lenncoder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String jobTitle;
    @Column(name = "user_id", unique = true)
    private Long userId;
    @Column(name = "department_id")
    private Long departmentId;


    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false, unique = true)
    private User user;

    // Many employees can belong to one department
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Department department;
}
