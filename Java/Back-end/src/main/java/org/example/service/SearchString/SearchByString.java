package org.example.service.SearchString;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.FormatInfo;
import org.example.service.strategies.StrategyGetCarsForString;

import java.util.List;

public class SearchByString implements StrategyGetCarsForString {

    private final CarsRepository carsRepository;

    public SearchByString ( CarsRepository carsRepository ) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> search ( String string ) {
        return List.of();
    }

    @Override
    public List<Cars> searchByFeature ( String string ) {
        String formattedStr = FormatInfo.check( string );
        return carsRepository.findByFeature( string );
    }

    @Override
    public List<Cars> searchByEngineType ( String string ) {
        String formattedStr = FormatInfo.check( string );
        return carsRepository.findByEngineType( string );
    }

    @Override
    public List<Cars> searchByProducedBy ( String string ) {
        String formattedStr = FormatInfo.check( string );
        return carsRepository.findProducedBy( string );
    }
}
