package org.example.service.context;

import org.example.model.Cars;
import org.example.service.strategies.StrategyGetCarsForString;

import java.util.List;

public class ContextSearchCarsForString {

    private final StrategyGetCarsForString strategy;

    public ContextSearchCarsForString ( StrategyGetCarsForString strategy ) {
        this.strategy = strategy;
    }

    public List<Cars> doSearch ( String string ) {
        return this.strategy.search( string );
    }

    public List<Cars> doSearchByEngyneType ( String string ) {
        return this.strategy.searchByEngineType( string );
    }

    public List<Cars> doSearchByFeature ( String string ) {
        return this.strategy.searchByFeature( string );
    }

    public List<Cars> doSearchByProducedBy ( String string ) {
        return this.strategy.searchByProducedBy( string );
    }

}
