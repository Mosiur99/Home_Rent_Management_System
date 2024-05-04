package com.home_rent.home_rent_management_system.entity;

import com.home_rent.home_rent_management_system.entity.enums.District;
import com.home_rent.home_rent_management_system.entity.enums.JobType;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Long age;
    @Enumerated(EnumType.ORDINAL)
    private JobType jobType;
    @Enumerated(EnumType.ORDINAL)
    private District district;
}
