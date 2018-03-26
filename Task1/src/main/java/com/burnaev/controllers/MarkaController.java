package com.burnaev.controllers;

import com.burnaev.models.Car;
import com.burnaev.models.Marka;
import com.burnaev.models.User;
import com.burnaev.services.AuthenticationService;
import com.burnaev.services.CarService;
import com.burnaev.services.MarkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MarkaController {
    @Autowired
    private MarkaService markaService;
    @Autowired
    private CarService carService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/home_page")
    public String getMarka(@ModelAttribute("model") ModelMap modelMap,
                           Authentication authentication){
        List<Marka> markaList = markaService.getMarks();
        if (authentication != null){
        User user = authenticationService.getUserByAuthentication(authentication);
        modelMap.addAttribute("user", user);

        }
        modelMap.addAttribute("markaList", markaList);
        return "home_page";
    }
    @GetMapping("/marka")
    public String getModelsofMarka(@ModelAttribute("model") ModelMap modelMap,
                                   @RequestParam(value = "id") Long markaId){
        List<Car> carList = carService.findAllCars(markaId);
        modelMap.addAttribute("carList", carList);
        return "cars_page";
    }

}
