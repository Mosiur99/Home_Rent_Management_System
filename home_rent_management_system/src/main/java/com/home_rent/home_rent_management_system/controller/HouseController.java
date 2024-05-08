package com.home_rent.home_rent_management_system.controller;

import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.Floor;
import com.home_rent.home_rent_management_system.entity.enums.HouseType;
import com.home_rent.home_rent_management_system.entity.enums.RentFor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HouseController {

    @GetMapping("/house-added")
    public String homeAdded(Model model) {
        model.addAttribute("Division", Division.values());
        model.addAttribute("HouseType", HouseType.values());
        model.addAttribute("Floor", Floor.values());
        model.addAttribute("RentFor", RentFor.values());

        return "houseAdded";
    }
}
