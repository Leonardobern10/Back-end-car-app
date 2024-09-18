package org.example.service.strategies;

import org.example.model.Cars;

import java.util.Optional;

public interface StrategyGetOneCarForString {
    Optional<Cars> search ( String string );
}
