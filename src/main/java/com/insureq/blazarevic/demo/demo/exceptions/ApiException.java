package com.insureq.blazarevic.demo.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiException {

    private String timeStamp;
    private String message;
    private String details;

    public ApiException(Date timeStamp, String message, String details) {
        this.timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timeStamp);
        this.message = message;
        this.details = details;
    }
}