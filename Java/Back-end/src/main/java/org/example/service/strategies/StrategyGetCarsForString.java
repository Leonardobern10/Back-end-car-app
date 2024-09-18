package org.example.service.strategies;

import org.example.model.Cars;

import java.util.List;

public interface StrategyGetCarsForString {
    List<Cars> search ( String string );
}
