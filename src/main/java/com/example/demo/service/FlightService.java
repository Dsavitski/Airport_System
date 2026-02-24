package com.example.demo.service;

import com.example.demo.dto.FlightDto;
import com.example.demo.entities.Flight;
import com.example.demo.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightDto createFlight(FlightDto dto) {
        Flight flight = new Flight();
        flight.setFlightNumber(dto.getFlightId());
        flight.setDestination(dto.getDestination());
        flight.setStatus(dto.getStatus());

        Flight saved = flightRepository.save(flight);
        return mapToDto(saved);
    }

    public FlightDto getById(Long id) {
        return flightRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + id));
    }

    public List<FlightDto> getByStatus(String status) {
        return flightRepository.findAll().stream()
                .filter(f -> f.getStatus().equalsIgnoreCase(status))
                .map(this::mapToDto)
                .toList();
    }

    private FlightDto mapToDto(Flight flight) {
        FlightDto dto = new FlightDto();
        dto.setFlightId(flight.getFlightNumber());
        dto.setDestination(flight.getDestination());
        dto.setStatus(flight.getStatus());
        return dto;
    }
}
