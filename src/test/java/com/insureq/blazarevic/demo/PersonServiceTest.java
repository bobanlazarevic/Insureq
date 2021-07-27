package com.insureq.blazarevic.demo;

import com.insureq.blazarevic.demo.model.Person;
import com.insureq.blazarevic.demo.repository.PersonRepository;
import com.insureq.blazarevic.demo.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Autowired
    @InjectMocks
    private PersonServiceImpl personService;

    private Person person1;
    private Person person2;

    List<Person> personList;

    @BeforeEach
    public void setUp() {
        personList = new ArrayList<>();

        Person person1 = new Person();
        person1.setId(1L);
        person1.setName("Boban");
        person1.setAddress("Address1");

        Person person2 = new Person();
        person2.setId(2L);
        person2.setName("Steva");
        person2.setAddress("Address2");

        personList.add(person1);
        personList.add(person2);
    }

    @AfterEach
    public void tearDown() {
        person1 = person2 = null;
        personList = null;
    }

    @Test
    void givenPersonToAddShouldReturnAddedPerson() {

        when(personRepository.save(any())).thenReturn(person1);
        personService.addPerson(person1);
        verify(personRepository,times(1)).save(any());

    }

    @Test
    public void GivenGetAllPersonsShouldReturnListOfAllPersons(){
        personRepository.save(person1);
        when(personRepository.findAll()).thenReturn(personList);
        List<Person> personList1 = personService.getAllPerson();
        assertEquals(personList1,personList);

        verify(personRepository,times(1)).save(person1);
        verify(personRepository,times(1)).findAll();
    }

}
