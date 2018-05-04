package com.burnaev.services;

import com.burnaev.models.City;
import com.burnaev.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findCitiesByCountryId(Long countryId) {
        return cityRepository.findAllByCountryId(countryId);
    }

    @Override
    public City findCityById(Long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public City findByName(String cityName) {
        return cityRepository.findOneByName(cityName);
    }

    @Override
    public List<City> findCitiesByLetters(String letter) {
        return cityRepository.findAllByNameLikeLetter("%" + letter + "%");
    }
}
