package com.insureq.blazarevic.demo.service.impl;

import com.insureq.blazarevic.demo.exceptions.EntityNotExistsException;
import com.insureq.blazarevic.demo.model.Person;
import com.insureq.blazarevic.demo.repository.PersonRepository;
import com.insureq.blazarevic.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(long id, Person person) {
        if(!Objects.nonNull(person))
            throw new IllegalStateException("Bad request");

        Optional<Person> p = personRepository.findById(id);

        if (p.isPresent()) {
            if (StringUtils.isNotEmpty(person.getName())) {
                p.get().setName(person.getName());
            }

            if (StringUtils.isNotEmpty(person.getAddress())) {
                p.get().setAddress(person.getAddress());
            }

            personRepository.save(p.get());
        } else {
            throw new EntityNotExistsException("Person with this " + id + " does not exists");
        }

        return p.get();
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotExistsException("Person with this " + id + " does not exists"));
    }

    @Override
    public Person deletePersonById(long id) {
        Person person = null;
        Optional optional = personRepository.findById(id);
        if (optional.isPresent()) {
            person = personRepository.findById(id).get();
            personRepository.deleteById(id);
        }
        return person;
    }
}
