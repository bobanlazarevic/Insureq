package com.insureq.blazarevic.demo;

import com.insureq.blazarevic.demo.model.Accident;
import com.insureq.blazarevic.demo.model.Car;
import com.insureq.blazarevic.demo.model.Person;
import com.insureq.blazarevic.demo.repository.AccidentRepository;
import com.insureq.blazarevic.demo.repository.CarRepository;
import com.insureq.blazarevic.demo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(AccidentRepository accidentRepository,
										 CarRepository carRepository,
										 PersonRepository personRepository) {
		return args -> {

			Person person = Person.builder()
					.name("Test")
					.address("Adresa")
					.build();

			Car car = Car.builder()
					.model("BMW")
					.year("2012")
					.person(person)
					.build();

			carRepository.save(car);

			Accident accident = Accident.builder()
					.location("BG")
					.createdAt(LocalDateTime.now())
					.build();

			accidentRepository.save(accident);

		};
	}

}
