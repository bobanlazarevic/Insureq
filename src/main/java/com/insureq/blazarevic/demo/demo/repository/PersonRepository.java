package com.insureq.blazarevic.demo.demo.repository;

import com.insureq.blazarevic.demo.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
