package com.home_rent.home_rent_management_system.entity;

import com.home_rent.home_rent_management_system.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String adminName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Role role = Role.ADMIN;
}
