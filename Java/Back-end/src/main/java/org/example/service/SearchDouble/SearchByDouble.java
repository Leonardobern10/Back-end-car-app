package org.example.service.SearchDouble;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.strategies.StrategyGetCarsForDouble;
import org.example.validations.CarValueValidation;

import java.util.List;

public class SearchByDouble implements StrategyGetCarsForDouble {


    private final CarsRepository carsRepository;

    public SearchByDouble ( CarsRepository carsRepository ) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> searchEquals ( Double value ) {
        CarValueValidation.validate( value );
        return carsRepository.findByValue( value );
    }

    @Override
    public List<Cars> searchBigger ( Double value ) {
        CarValueValidation.validate( value );
        return carsRepository.findBiggerThanValue( value );
    }

    @Override
    public List<Cars> searchLess ( Double value ) {
        CarValueValidation.validate( value );
        return carsRepository.findByLessThanValue( value );
    }
}
