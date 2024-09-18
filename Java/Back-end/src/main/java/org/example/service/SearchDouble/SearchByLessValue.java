package org.example.service.SearchDouble;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.strategies.StrategyGetCarsForValue;
import org.example.validations.CarValueValidation;

import java.util.List;

public class SearchByLessValue implements StrategyGetCarsForValue {

    private final CarsRepository carsRepository;

    public SearchByLessValue ( CarsRepository carsRepository ) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> search ( Double value ) {
        CarValueValidation.validate( value );
        return carsRepository.findByLessThanValue( value );
    }
}
