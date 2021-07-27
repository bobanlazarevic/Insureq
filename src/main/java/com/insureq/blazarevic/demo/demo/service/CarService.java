package com.insureq.blazarevic.demo.demo.service;

import com.insureq.blazarevic.demo.demo.model.Car;

import java.util.List;

public interface CarService {
    Car addCar(Car car);
    Car updateCar(long id);
    List<Car> getAllCar();
    Car getCarById(long id);
    Car deleteCarById(long id);
}
