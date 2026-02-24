package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight {
    private Long id;
    private String flightNumber;
    private String destination;
    private String status;
}
