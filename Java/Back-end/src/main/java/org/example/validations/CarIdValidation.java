package org.example.validations;

import org.example.exceptions.FieldIntegerInvalid;
import org.example.model.Cars;

public class CarIdValidation {
    public static void validate(int id) {
        if (id < 0)
            throw new FieldIntegerInvalid("ID INVÁLIDO!");
    }
}
