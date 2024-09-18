package org.example.service.SearchString;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.FormatInfo;
import org.example.service.strategies.StrategyGetCarsForString;

import java.util.List;

public class SearchByProducedBy implements StrategyGetCarsForString {

    private final CarsRepository carsRepository;

    public SearchByProducedBy ( CarsRepository carsRepository ) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> search ( String string ) {
        String formattedStr = FormatInfo.check( string );
        return carsRepository.findProducedBy( string );
    }
}
