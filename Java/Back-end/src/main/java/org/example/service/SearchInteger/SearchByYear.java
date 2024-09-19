package org.example.service.SearchInteger;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.strategies.StrategyGetCarsForYear;
import org.example.validations.IntegerValidation;

import java.util.List;

public class SearchByYear implements StrategyGetCarsForYear {

    private final CarsRepository carsRepository;

    public SearchByYear ( CarsRepository carsRepository ) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> searchEquals ( Integer year ) {
        IntegerValidation.validate( year );
        return carsRepository.findByYear( year );
    }

    @Override
    public List<Cars> searchNewer ( Integer year ) {
        IntegerValidation.validate( year );
        return carsRepository.findNewerThanYear( year );
    }

    @Override
    public List<Cars> searchOlder ( Integer year ) {
        IntegerValidation.validate( year );
        return carsRepository.findOlderThanYear( year );
    }
}
