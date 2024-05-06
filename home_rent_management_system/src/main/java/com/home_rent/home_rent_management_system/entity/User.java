package com.home_rent.home_rent_management_system.entity;

import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.JobType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    private JobType jobType;

    @Enumerated(EnumType.ORDINAL)
    private Division division;
}
