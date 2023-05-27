package org.jotasilva.validator;

import org.jotasilva.entities.enums.VehicleType;

import java.security.InvalidParameterException;

public class VehicleValidator {

    public static Boolean isValidVehicle(String plate, String type) {
        return validatePlate(plate) && validateVehicleType(type);
    }

    public static Boolean validatePlate(String plate) {
        String oldPattern = "^[A-Z]{3}-\\d{4}$";
        String newPattern = "^[A-Z]{3}-\\d{1}[A-Z0-9]{1}\\d{2}$";

        return plate.matches(oldPattern) || plate.matches(newPattern);
    }

    public static Boolean validateVehicleType(String type) {
        try {
            VehicleType.valueOf(type.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static VehicleType convertToVehicleType(String type) {
        return VehicleType.valueOf(type.toUpperCase());
    }
}
