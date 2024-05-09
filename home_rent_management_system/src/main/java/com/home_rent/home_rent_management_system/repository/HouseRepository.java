package com.home_rent.home_rent_management_system.repository;

import com.home_rent.home_rent_management_system.entity.House;
import com.home_rent.home_rent_management_system.entity.enums.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    @Query(value = "SELECT house FROM House house WHERE house.id = :houseId")
    House getHouse(@Param("houseId") Long houseId);

    @Query(value = "SELECT house FROM House house WHERE house.division = :division")
    List<House> getHousesByDivision(@Param("division") Division division);
}
