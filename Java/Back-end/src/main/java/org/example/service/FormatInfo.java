package org.example.service;

import org.example.validations.CarStringValidation;

public class FormatInfo {
    public static String check ( String id ) {
        CarStringValidation.validate( id, "FIELD IS NOT VALID" + id );
        return id.trim();
    }
}
