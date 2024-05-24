package com.home_rent.home_rent_management_system.service.impl;

import com.home_rent.home_rent_management_system.entity.Division;
import com.home_rent.home_rent_management_system.repository.DivisionRepository;
import com.home_rent.home_rent_management_system.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;

    @Autowired
    public DivisionServiceImpl(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void divisionAdded(String divisionName) {
        Division division = new Division();
        division.setName(divisionName);
        divisionRepository.save(division);
    }
}
