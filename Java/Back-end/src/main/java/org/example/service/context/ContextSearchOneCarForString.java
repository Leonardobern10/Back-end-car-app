package org.example.service.context;

import org.example.model.Cars;
import org.example.service.strategies.StrategyGetOneCarForString;

import java.util.Optional;

public class ContextSearchOneCarForString {

    private final StrategyGetOneCarForString strategy;

    public ContextSearchOneCarForString ( StrategyGetOneCarForString strategy ) {
        this.strategy = strategy;
    }

    public Optional<Cars> doSearch ( String string ) {
        return this.strategy.search( string );
    }
}
