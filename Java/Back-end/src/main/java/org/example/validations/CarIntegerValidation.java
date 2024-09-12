package org.example.validations;

import org.example.exceptions.FieldDoubleInvalidException;

public class CarIntegerValidation {
    public static void validate ( Integer carValue ) {
        if ( carValue < 0 )
            throw new FieldDoubleInvalidException( "FIELD CAR_VALUE IS INVALID" );
    }
}
