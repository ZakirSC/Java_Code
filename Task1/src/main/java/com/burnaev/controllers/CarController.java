package com.burnaev.controllers;


import com.burnaev.models.Car;
import com.burnaev.models.User;
import com.burnaev.services.AuthenticationService;
import com.burnaev.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/car")
    public String getCarPage(@ModelAttribute("model")ModelMap modelMap,
                             @RequestParam(value = "id") Long carId,
                             Authentication authentication){
        Car car = carService.findCarById(carId);
        if (authentication != null){
        User user = authenticationService.getUserByAuthentication(authentication);
        modelMap.addAttribute("user", user);
        }
        modelMap.addAttribute("car", car);
        return "car_page";
    }
}
