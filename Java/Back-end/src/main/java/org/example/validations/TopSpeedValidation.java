package org.example.validations;

public class TopSpeedValidation {
    public static String validate ( Integer topSpeed ) {
        IntegerValidation.validate( topSpeed );
        return topSpeed.toString() + " mph";
    }
}
