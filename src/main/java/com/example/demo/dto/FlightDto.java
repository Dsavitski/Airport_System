package com.example.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FlightDto {
    private String flightId;
    private String destination;
    private String status;
}
