package org.jotasilva.validator;

import org.jotasilva.entities.enums.VehicleType;

public class VehicleValidator {
    /*
    private String plate; - ok
    private VehicleType type;
    private Owner owner;
    *
    * */

    public static Boolean validatePlate(String plate){
        String pattern = "^[A-Za-z]{3}\\d{1}[A-Za-z]{1}\\d{2}$";
        return plate.matches(pattern);
    }

    public static Boolean validateVehicleType(String type){
        try {
            VehicleType.valueOf(type.toUpperCase());
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }
}
