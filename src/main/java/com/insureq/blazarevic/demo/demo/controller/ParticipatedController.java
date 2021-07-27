package com.insureq.blazarevic.demo.demo.controller;

import com.insureq.blazarevic.demo.demo.model.Participated;
import com.insureq.blazarevic.demo.demo.model.Person;
import com.insureq.blazarevic.demo.demo.model.dto.ParticipatedDTO;
import com.insureq.blazarevic.demo.demo.service.ParticipatedService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class ParticipatedController {

    private final ParticipatedService participatedService;

    @PostMapping("/saveparticipated")
    public ResponseEntity<Participated> saveParticipated(@RequestBody ParticipatedDTO participatedDTO) {
        Participated participated = participatedService.insertParticipated(participatedDTO.getLicence(), participatedDTO.getReport(), participatedDTO.getAmount());
        return new ResponseEntity<>(participated, HttpStatus.CREATED);
    }

}
