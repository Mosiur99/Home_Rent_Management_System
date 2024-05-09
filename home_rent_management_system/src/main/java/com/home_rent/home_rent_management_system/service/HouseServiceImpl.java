package com.home_rent.home_rent_management_system.service;

import com.home_rent.home_rent_management_system.entity.House;
import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.HouseType;
import com.home_rent.home_rent_management_system.entity.enums.RentFor;
import com.home_rent.home_rent_management_system.exception.ResourceNotFoundExceptionHandler;
import com.home_rent.home_rent_management_system.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Service
public class HouseServiceImpl implements HouseService{

    private final HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public House getHouse(Long houseId) {
        House house = houseRepository.getHouse(houseId);
        if(Objects.isNull(house)) {
            throw new ResourceNotFoundExceptionHandler("This house isn't exist");
        }

        return house;
    }

    @Override
    public void houseAdded(Long roomSize,
                           RentFor rentFor,
                           String location,
                           Long roadNumber,
                           String houseName,
                           Long houseNumber,
                           Division division,
                           String description,
                           HouseType houseType,
                           LocalDate availableDate) {
        House house = new House();
        house.setRoomSize(roomSize);
        house.setRentFor(rentFor);
        house.setLocation(location);
        house.setRoadNumber(roadNumber);
        house.setHouseName(houseName);
        house.setHouseNumber(houseNumber);
        house.setDivision(division);
        house.setDescription(description);
        house.setHouseType(houseType);
        house.setAvailableDate(availableDate);
        houseRepository.save(house);
    }
}
