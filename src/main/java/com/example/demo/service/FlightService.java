package com.example.demo.service;

import com.example.demo.dto.FlightDto;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public FlightDto getById(Long id) {
        return flightRepository.findById(id).map(flightMapper::toDto).orElse(null);
    }
    public List<FlightDto> getByStatus(String status) {
        return flightRepository.findAll().stream().filter(flight -> flight.getStatus().equalsIgnoreCase(status)).
                map(flightMapper::toDto).toList();
    }


}
