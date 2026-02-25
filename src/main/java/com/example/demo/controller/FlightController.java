package com.example.demo.controller;

import com.example.demo.dto.FlightDto;
import com.example.demo.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/{id}")
    public FlightDto getById(@PathVariable Long id) {
        return flightService.getById(id);
    }

    @GetMapping
    public List<FlightDto> getFlightByStatus(@RequestParam String status) {
        return flightService.getByStatus(status);
    }
}
