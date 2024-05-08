package com.home_rent.home_rent_management_system.entity;

import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.Floor;
import com.home_rent.home_rent_management_system.entity.enums.HouseType;
import com.home_rent.home_rent_management_system.entity.enums.RentFor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long houseNumber;

    @Column(nullable = false)
    private Long roadNumber;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDate availableDate;

    @Column(nullable = false)
    private Long roomSize;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Division division;

    @Enumerated(EnumType.ORDINAL)
    private RentFor rentFor;

    @Enumerated(EnumType.ORDINAL)
    private HouseType houseType;

    @Enumerated(EnumType.ORDINAL)
    private Floor floor;

    @OneToMany(mappedBy = "house")
    private List<Review> reviews;
}
