package com.insureq.blazarevic.demo.service;

import com.insureq.blazarevic.demo.model.Participated;

public interface ParticipatedService {

    Participated insertParticipated(long licence, long report, int amount);
}
