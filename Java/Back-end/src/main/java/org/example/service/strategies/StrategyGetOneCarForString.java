package org.example.service.strategies;

import org.example.model.Cars;

import java.util.Optional;

public interface StrategyGetOneCarForString {
    Optional<Cars> searchId ( String string );

    Optional<Cars> searchModel ( String string );
}
