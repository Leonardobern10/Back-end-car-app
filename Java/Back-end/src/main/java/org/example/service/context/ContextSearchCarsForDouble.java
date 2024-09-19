package org.example.service.context;

import org.example.model.Cars;
import org.example.service.strategies.StrategyGetCarsForDouble;

import java.util.List;

public class ContextSearchCarsForDouble {

    private final StrategyGetCarsForDouble strategy;

    public ContextSearchCarsForDouble ( StrategyGetCarsForDouble strategy ) {
        this.strategy = strategy;
    }

    public List<Cars> doSearchEquals ( Double value ) {
        return this.strategy.searchEquals( value );
    }

    public List<Cars> doSearchBigger ( Double value ) {
        return this.strategy.searchBigger( value );
    }

    public List<Cars> doSearchLess ( Double value ) {
        return this.strategy.searchLess( value );
    }
}
