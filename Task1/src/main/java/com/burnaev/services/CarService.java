package com.burnaev.services;


import com.burnaev.models.Car;

import java.util.List;

public interface CarService {
    List<Car> findAllCars(Long markaId);

    Car findCarById(Long carId);
}
