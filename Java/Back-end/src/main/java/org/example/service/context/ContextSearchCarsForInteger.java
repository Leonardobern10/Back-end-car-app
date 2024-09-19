package org.example.service.context;

import org.example.model.Cars;
import org.example.service.strategies.StrategyGetCarsForYear;

import java.util.List;

public class ContextSearchCarsForInteger {

    private final StrategyGetCarsForYear strategy;

    public ContextSearchCarsForInteger ( StrategyGetCarsForYear strategy ) {
        this.strategy = strategy;
    }

    public List<Cars> doSearchEquals ( Integer year ) {
        return this.strategy.searchEquals( year );
    }

    public List<Cars> doSearchNewer ( Integer year ) {
        return this.strategy.searchNewer( year );
    }

    public List<Cars> doSearchOlder ( Integer year ) {
        return this.strategy.searchOlder( year );
    }
}
