package com.insureq.blazarevic.demo.service;

import com.insureq.blazarevic.demo.model.Accident;
import java.util.List;

public interface AccidentService {
    Accident addAccident(Accident accident);
    Accident updateAccident(long id);
    List<Accident> getAllAccident();
    Accident getAccidentById(long id);
    Accident deleteAccidentById(long id);
}
