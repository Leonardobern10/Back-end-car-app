package org.example.service.SearchString;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.FormatInfo;
import org.example.service.strategies.StrategyGetOneCarForString;
import org.example.validations.CarValidations;

import java.util.Optional;

public class SearchById implements StrategyGetOneCarForString {

    private final CarValidations carValidations;
    private final CarsRepository carsRepository;

    public SearchById ( CarsRepository carsRepository, CarValidations carValidations ) {
        this.carsRepository = carsRepository;
        this.carValidations = carValidations;
    }

    @Override
    public Optional<Cars> search ( String string ) {
        String formattedId = FormatInfo.check( string );
        carValidations.validateCarExistence( string );
        return Optional.of( carsRepository.findById( string ).orElseThrow() );
    }
}
