package com.home_rent.home_rent_management_system.controller;

import com.home_rent.home_rent_management_system.entity.House;
import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.Floor;
import com.home_rent.home_rent_management_system.entity.enums.HouseType;
import com.home_rent.home_rent_management_system.entity.enums.RentFor;
import com.home_rent.home_rent_management_system.service.HouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }


    @GetMapping("/house-added")
    public String houseAdded(Model model) {
        model.addAttribute("Division", Division.values());
        model.addAttribute("HouseType", HouseType.values());
        model.addAttribute("Floor", Floor.values());
        model.addAttribute("RentFor", RentFor.values());

        return "houseAdded";
    }

    @PostMapping("/house-added")
    public String houseAdded(@RequestParam Floor floor,
                             @RequestParam Long roomSize,
                             @RequestParam RentFor rentFor,
                             @RequestParam String location,
                             @RequestParam Long roadNumber,
                             @RequestParam String houseName,
                             @RequestParam Long houseNumber,
                             @RequestParam Division division,
                             @RequestParam String description,
                             @RequestParam HouseType houseType,
                             @RequestParam LocalDate availableDate
                            ) {
        houseService.houseAdded(floor, roomSize, rentFor, location, roadNumber, houseName, houseNumber,
                division, description, houseType, availableDate);
        return "redirect:/house-added";
    }

    @GetMapping("/houses")
    public String getHouses(Model model) {
        List<House> houses = houseService.getHouses();
        model.addAttribute("houses", houses);
        return "home";
    }

    @GetMapping("/houses/{Division}")
    public String getHousesByDivision(Model model, @PathVariable(name = "Division", required = true) Division division) {
        List<House> houses = houseService.getHousesByDivision(division);
        model.addAttribute("houses", houses);
        return "housesByDivision";
    }

    @GetMapping("/house/{houseId}")
    public String houseDetails(Model model, @PathVariable Long houseId) {
        House house = houseService.getHouse(houseId);
        model.addAttribute("house", house);
        return "houseDetails";
    }
}
