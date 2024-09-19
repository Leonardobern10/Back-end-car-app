package org.example.service.strategies;

import org.example.model.Cars;

import java.util.List;

public interface StrategyGetCarsForString {
    List<Cars> search ( String string );

    List<Cars> searchByFeature ( String string );

    List<Cars> searchByEngineType ( String string );

    List<Cars> searchByProducedBy ( String string );
}
