package org.example.validations;

import org.example.exceptions.FieldDoubleInvalid;

public class CarValueValidation {
    public static void validate (double carValue) {
        if (Double.isInfinite(carValue) || Double.isNaN(carValue) || carValue < 0)
            throw new FieldDoubleInvalid("FIELD CAR_VALUE IS INVALID");
    }
}
