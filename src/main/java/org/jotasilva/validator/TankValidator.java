package org.jotasilva.validator;

public class TankValidator {
    public static Boolean isValidTank(Double capacity){
        return capacity > 0.0 && capacity < 50000.00;
    }
}
