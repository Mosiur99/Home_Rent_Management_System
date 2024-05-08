package com.home_rent.home_rent_management_system.service;

import com.home_rent.home_rent_management_system.entity.House;
import com.home_rent.home_rent_management_system.repository.HouseRepository;
import org.springframework.stereotype.Service;

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
            throw new
        }
    }
}
