package com.insureq.blazarevic.demo.demo.repository;

import com.insureq.blazarevic.demo.demo.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
