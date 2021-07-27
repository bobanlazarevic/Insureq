package com.insureq.blazarevic.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ParticipatedDTO {

    private Long licence;
    private Long report;
    private int amount;
}
