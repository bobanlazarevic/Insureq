package com.insureq.blazarevic.demo.demo.controller;

import com.insureq.blazarevic.demo.demo.model.Person;
import com.insureq.blazarevic.demo.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(
                personService.getAllPerson(), HttpStatus.OK);
    }

    @PostMapping(value = "/createperson", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person addPerson = personService.addPerson(person);
        return new ResponseEntity<>(addPerson, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteperson/{personID}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long personID) {
        Person person = personService.deletePersonById(personID);
        return Objects.nonNull(person) ? new ResponseEntity<>(HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/updateperson/{personID}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long personID) {
        return null;
    }
}
