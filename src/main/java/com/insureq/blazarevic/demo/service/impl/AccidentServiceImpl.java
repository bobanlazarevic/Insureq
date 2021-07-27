package com.insureq.blazarevic.demo.service.impl;

import com.insureq.blazarevic.demo.exceptions.EntityNotExistsException;
import com.insureq.blazarevic.demo.model.Accident;
import com.insureq.blazarevic.demo.repository.AccidentRepository;
import com.insureq.blazarevic.demo.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;

    @Override
    public Accident addAccident(Accident accident) {
        return accidentRepository.save(accident);
    }

    @Override
    public Accident updateAccident(long id) {
//        if(accidentRepository.existsById(accident.getId())){
//            throw new IllegalStateException("Accident with this ID already exists");
//        }
//        return accidentRepository.save(accident);
        return null;
    }

    @Override
    public List<Accident> getAllAccident() {
        return accidentRepository.findAll();
    }

    @Override
    public Accident getAccidentById(long id) {
        return accidentRepository.findById(id).orElseThrow(() -> new EntityNotExistsException("Accident with this " + id + " does not exists"));
    }

    @Override
    public Accident deleteAccidentById(long id) {
        Accident accident = null;
        Optional optional = accidentRepository.findById(id);
        if (optional.isPresent()) {
            accident = accidentRepository.findById(id).get();
            accidentRepository.deleteById(id);
        }
        return accident;
    }
}
