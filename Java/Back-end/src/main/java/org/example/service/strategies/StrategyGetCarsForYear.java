package org.example.service.strategies;

import org.example.model.Cars;

import java.util.List;

public interface StrategyGetCarsForYear {
    List<Cars> search ( Integer year );
}
