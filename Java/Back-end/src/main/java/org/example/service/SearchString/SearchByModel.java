package org.example.service.SearchString;

import org.example.model.Cars;

import org.example.repository.CarsRepository;
import org.example.service.strategies.StrategyGetOneCarForString;

import java.util.Optional;

public class SearchByModel implements StrategyGetOneCarForString {

    private final CarsRepository carsRepository;

    public SearchByModel ( CarsRepository carsRepository ) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Optional<Cars> search ( String string ) {
        return Optional.ofNullable( carsRepository.findByModel( string ) );
    }
}
