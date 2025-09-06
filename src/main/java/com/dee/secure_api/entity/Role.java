package com.dee.secure_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // store enum as text
    @Column(length = 20, unique = true, nullable = false)
    private ERole name;

    public Role() {}
    public Role(ERole name) { this.name = name; }
}
