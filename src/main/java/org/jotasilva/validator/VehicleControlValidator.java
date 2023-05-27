package org.jotasilva.validator;

import org.jotasilva.entities.VehicleControl;

import java.util.List;

public class VehicleControlValidator {
    /*
    private Double odometer;
    private Double quantityLiters;
    private LocalDate provisionDate;
    */

    public static Boolean isValidVehicleControl(int odometer, Double quantity){
        return validateOdometer(odometer) && validateQuantityLiters(quantity);
    }

    public static Boolean validateOdometer(int odometer) {
        // por enquanto validar apenas se o valor é válido.
        return odometer > 0;
    }

    public static Boolean validateQuantityLiters(Double quantity) {
        return quantity > 0;
    }

    // precisa-se criar uma validação sobre os odometros existentes na hora da criação de um novo lançamento de um VehicleControl
    // pensar em maneiras de efetuar essa busca.
    // dica: realizar get na tabela, depois realizar filtro com stream.

}
