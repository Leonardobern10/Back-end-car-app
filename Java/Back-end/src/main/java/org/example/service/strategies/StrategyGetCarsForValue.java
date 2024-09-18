package org.example.service.strategies;

import org.example.model.Cars;

import java.util.List;

public interface StrategyGetCarsForValue {
    List<Cars> search ( Double value );
}
