package com.burnaev.controllers;

import com.burnaev.models.City;
import com.burnaev.models.Country;
import com.burnaev.services.CityService;
import com.burnaev.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CountriesController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;

    @GetMapping("/countries")
    public String showCountries(@ModelAttribute("model") ModelMap modelMap,
                                @RequestParam(value = "id", defaultValue = "1") Long countryId,
                                @RequestParam(value = "cityid", defaultValue = "1") Long cityId) {
        List<Country> countries = countryService.getAllCountries();
        modelMap.addAttribute("countries", countries);
        List<City> cities = cityService.findCitiesByCountryId(countryId);
        modelMap.addAttribute("cities", cities);
        modelMap.addAttribute("choice", countryId);
        City city = cityService.findCityById(cityId);
        modelMap.addAttribute("city", city);
        return "countries_page";
    }
    @GetMapping("/search")
    public String searchCityByName(@ModelAttribute("model") ModelMap modelMap,
                                   @RequestParam("search") String search){
        modelMap.addAttribute("search", search);
        City cityByName = cityService.findByName(search);
        modelMap.addAttribute("cityByName", cityByName);
        return "search";
    }

}
