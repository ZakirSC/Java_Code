package com.burnaev.services;

import com.burnaev.models.Car;
import com.burnaev.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> findAllCars(Long markaId) {
        return carRepository.findCarsByMarkaId(markaId);
    }

    @Override
    public Car findCarById(Long carId) {
        return carRepository.findOne(carId);
    }
}
