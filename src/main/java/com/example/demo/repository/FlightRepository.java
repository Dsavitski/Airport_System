package com.example.demo.repository;


import com.example.demo.entities.Flight;
import lombok.Getter;
import org.springframework.stereotype.Repository;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Getter
public class FlightRepository {

    private final List<Flight> flights = new LinkedList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Flight save(Flight flight){
        flight.setId(idGen.getAndIncrement());
        flights.add(flight);
        return flight;
    }

    public Optional<Flight> findById(Long id){
        return flights.stream().filter(f -> f.getId().equals(id))
                .findFirst();
    }

    public List<Flight> findAll(){
        return new LinkedList<>(flights);
    }

}
