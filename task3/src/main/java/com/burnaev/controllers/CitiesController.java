/*
package com.burnaev.controllers;


import com.burnaev.models.City;
import com.burnaev.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CitiesController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public String showCities(@ModelAttribute("model")ModelMap modelMap,
                             @RequestParam(value = "id") Long countryId){
        List<City> cities = cityService.findCitiesByCountryId(countryId);
        modelMap.addAttribute("cities", cities);
        return "cities_page";
    }
}
*/
