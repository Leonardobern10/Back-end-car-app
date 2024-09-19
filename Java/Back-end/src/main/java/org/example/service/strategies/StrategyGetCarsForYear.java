package org.example.service.strategies;

import org.example.model.Cars;

import java.util.List;

public interface StrategyGetCarsForYear {
    List<Cars> searchEquals ( Integer year );

    List<Cars> searchNewer ( Integer year );

    List<Cars> searchOlder ( Integer year );
}
