package com.burnaev.repositories;

import com.burnaev.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCountryId(Long countryId);
    City findById(Long cityId);
}
