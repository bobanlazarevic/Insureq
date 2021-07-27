package com.insureq.blazarevic.demo.demo.repository;

import com.insureq.blazarevic.demo.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
