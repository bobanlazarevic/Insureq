package com.insureq.blazarevic.demo.demo.service.impl;

import com.insureq.blazarevic.demo.demo.exceptions.EntityNotExistsException;
import com.insureq.blazarevic.demo.demo.model.Accident;
import com.insureq.blazarevic.demo.demo.model.Car;
import com.insureq.blazarevic.demo.demo.model.Participated;
import com.insureq.blazarevic.demo.demo.repository.ParticipatedRepository;
import com.insureq.blazarevic.demo.demo.service.AccidentService;
import com.insureq.blazarevic.demo.demo.service.CarService;
import com.insureq.blazarevic.demo.demo.service.ParticipatedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class ParticipatedServiceImpl implements ParticipatedService {

    private final CarService carService;
    private final AccidentService accidentService;

    private final ParticipatedRepository participatedRepository;

    @Override
    public Participated insertParticipated(long licence, long report, int amount) {
        Car car = carService.getCarById(licence);
        Accident accident = accidentService.getAccidentById(report);

        Participated participated = Participated.builder().build();
        if(Objects.nonNull(car) && Objects.nonNull(accident)) {
            participated.setAccident(accident);
            participated.setCar(car);
            participated.setDamageAmount(amount);

            participatedRepository.save(participated);

            return participated;
        } else {
            throw new EntityNotExistsException("Accident or Car does not exists.");
        }
    }
}
