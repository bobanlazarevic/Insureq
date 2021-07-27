package com.insureq.blazarevic.demo.service.impl;

import com.insureq.blazarevic.demo.exceptions.EntityNotExistsException;
import com.insureq.blazarevic.demo.model.Car;
import com.insureq.blazarevic.demo.repository.CarRepository;
import com.insureq.blazarevic.demo.service.CarService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        // TODO: Validation
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(long id, Car car) {
        if(!Objects.nonNull(car))
            throw new IllegalStateException("Bad request");

        Optional<Car> p = carRepository.findById(id);

        if (p.isPresent()) {
            if (StringUtils.isNotEmpty(car.getModel())) {
                p.get().setModel(car.getModel());
            }

            if (StringUtils.isNotEmpty(car.getYear())) {
                p.get().setYear(car.getYear());
            }

            carRepository.save(p.get());
        } else {
            throw new EntityNotExistsException("Car with this " + id + " does not exists");
        }

        return p.get();
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
