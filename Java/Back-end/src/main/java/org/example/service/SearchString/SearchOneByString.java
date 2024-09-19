package org.example.service.SearchString;

import org.example.model.Cars;

import org.example.repository.CarsRepository;
import org.example.service.FormatInfo;
import org.example.service.strategies.StrategyGetOneCarForString;
import org.example.validations.CarValidations;

import java.util.Optional;

public class SearchOneByString implements StrategyGetOneCarForString {

    private final CarsRepository carsRepository;
    private final CarValidations carValidations;

    public SearchOneByString ( CarsRepository carsRepository, CarValidations carValidations ) {
        this.carValidations = carValidations;
        this.carsRepository = carsRepository;
    }

    @Override
    public Optional<Cars> searchId ( String string ) {
        String formattedId = FormatInfo.check( string );
        carValidations.validateCarExistence( string );
        return Optional.of( carsRepository.findById( string ).orElseThrow() );
    }

    @Override
    public Optional<Cars> searchModel ( String string ) {
        return Optional.ofNullable( carsRepository.findByModel( string ) );
    }
}
