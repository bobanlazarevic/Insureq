package com.insureq.blazarevic.demo.demo.service.impl;

import com.insureq.blazarevic.demo.demo.exceptions.EntityNotExistsException;
import com.insureq.blazarevic.demo.demo.model.Accident;
import com.insureq.blazarevic.demo.demo.model.Car;
import com.insureq.blazarevic.demo.demo.repository.CarRepository;
import com.insureq.blazarevic.demo.demo.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(long id) {
        return null;
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(long id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotExistsException("Car with this " + id + " does not exists"));
    }

    @Override
    public Car deleteCarById(long id) {
        Car car = null;
        Optional optional = carRepository.findById(id);
        if (optional.isPresent()) {
            car = carRepository.findById(id).get();
            carRepository.deleteById(id);
        }
        return car;
    }
}
