package org.example.validations;

import org.example.utils.Metrics;

public class TopSpeedValidation {
    public static String validate ( Integer topSpeed ) {
        IntegerValidation.validate( topSpeed );
        return topSpeed.toString() + Metrics.SPEED_UNITY;
    }
}
