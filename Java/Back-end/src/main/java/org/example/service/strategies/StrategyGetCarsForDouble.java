package org.example.service.strategies;

import org.example.model.Cars;

import java.util.List;

public interface StrategyGetCarsForDouble {
    List<Cars> searchEquals ( Double value );

    List<Cars> searchBigger ( Double value );

    List<Cars> searchLess ( Double value );
}
