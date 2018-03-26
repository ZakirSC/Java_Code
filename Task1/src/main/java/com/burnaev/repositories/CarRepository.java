package com.burnaev.repositories;


import com.burnaev.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByMarkaId(Long id);
}
