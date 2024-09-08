package org.example.validations;

import org.example.exceptions.FieldStringInvalid;

public class CarUrlValidation {
    public static void validate (String url) {
        if (url.isBlank() || url.isEmpty())
            throw new FieldStringInvalid("FIELD URL IS INVALID");
    }
}
