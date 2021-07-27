package com.insureq.blazarevic.demo.service;

import com.insureq.blazarevic.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(long id, Person person);
    List<Person> getAllPerson();
    Person getPersonById(long id);
    Person deletePersonById(long id);
}
