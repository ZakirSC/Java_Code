package com.burnaev.repositories;

import com.burnaev.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCountryId(Long countryId);
    City findById(Long cityId);
    City findOneByName(String name);

    @Query("select c from City c where c.name like :letter")
    List<City> findAllByNameLikeLetter(@Param("letter") String letter);
}
