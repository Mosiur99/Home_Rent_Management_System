package com.home_rent.home_rent_management_system.service;

import com.home_rent.home_rent_management_system.entity.House;
import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.HouseType;
import com.home_rent.home_rent_management_system.entity.enums.RentFor;

import java.time.LocalDate;

public interface HouseService {

    House getHouse(Long houseId);

    void houseAdded(Long roomSize,
                    RentFor rentFor,
                    String location,
                    Long roadNumber,
                    String houseName,
                    Long houseNumber,
                    Division division,
                    String description,
                    HouseType houseType,
                    LocalDate availableDate);
}
