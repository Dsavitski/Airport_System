package com.example.demo.mapper;

import com.example.demo.dto.FlightDto;
import com.example.demo.entities.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public FlightDto toDto(Flight flight) {
        if (flight == null) {
            return null;
        }
        return new FlightDto(
                flight.getFlightNumber(),
                flight.getDestination(),
                flight.getStatus()
        );
    }
}
