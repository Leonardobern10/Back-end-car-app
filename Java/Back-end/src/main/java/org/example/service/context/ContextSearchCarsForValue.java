package org.example.service.context;

import org.example.model.Cars;
import org.example.service.strategies.StrategyGetCarsForValue;

import java.util.List;

public class ContextSearchCarsForValue {

    private final StrategyGetCarsForValue strategy;

    public ContextSearchCarsForValue ( StrategyGetCarsForValue strategy ) {
        this.strategy = strategy;
    }

    public List<Cars> doSearch ( Double value ) {
        return this.strategy.search( value );
    }
}
