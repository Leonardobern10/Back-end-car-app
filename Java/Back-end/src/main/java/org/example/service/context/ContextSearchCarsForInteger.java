package org.example.service.context;

import org.example.model.Cars;
import org.example.service.strategies.StrategyGetCarsForYear;

import java.util.List;

public class ContextSearchCarsForInteger {

    private final StrategyGetCarsForYear strategy;

    public ContextSearchCarsForInteger ( StrategyGetCarsForYear strategy ) {
        this.strategy = strategy;
    }

    public List<Cars> doSearch ( Integer year ) {
        return this.strategy.search( year );
    }
}
