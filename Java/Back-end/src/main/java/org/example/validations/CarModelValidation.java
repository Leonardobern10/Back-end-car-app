package org.example.validations;

import org.example.exceptions.FieldStringInvalid;

public class CarModelValidation {
    public static void validate (String field) {
        if (field == null || field.isBlank())
            throw new FieldStringInvalid("FIELD MODEL IS INVALID!");
    }
}
