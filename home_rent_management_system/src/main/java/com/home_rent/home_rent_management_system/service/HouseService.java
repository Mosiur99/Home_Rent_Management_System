package com.home_rent.home_rent_management_system.service;

import com.home_rent.home_rent_management_system.entity.House;
import com.home_rent.home_rent_management_system.entity.enums.Floor;
import com.home_rent.home_rent_management_system.entity.enums.HouseType;
import com.home_rent.home_rent_management_system.entity.enums.RentFor;

import java.time.LocalDate;
import java.util.List;

public interface HouseService {

    List<House> getHouses();

//    List<House> getHousesByDivision(Division division);

    House getHouse(Long houseId);

    void houseAdded(Floor floor,
                    Long roomSize,
                    RentFor rentFor,
                    String location,
                    Long roadNumber,
                    String houseName,
                    Long houseNumber,
                    String description,
                    HouseType houseType,
                    LocalDate availableDate);
}
