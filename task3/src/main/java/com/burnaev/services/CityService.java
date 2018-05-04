package com.burnaev.services;


import com.burnaev.models.City;

import java.util.List;

public interface CityService {
    List<City> findCitiesByCountryId(Long countryId);
    City findCityById(Long cityId);
    City findByName(String cityName);

    List<City> findCitiesByLetters(String letter);
}
