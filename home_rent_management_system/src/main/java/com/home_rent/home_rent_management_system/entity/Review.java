package com.home_rent.home_rent_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String comment;

    private int rating;

    @Column(nullable = false)
    private Date createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

    @ManyToOne()
    @JoinColumn(name = "house_id")
    private House house;
}
