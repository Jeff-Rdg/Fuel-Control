package validatorTest;

import org.jotasilva.validator.VehicleControlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleControlValidatorTest {
    @Test
    void validateOdometer_valid(){
        int odometer = 110;
        Boolean isValid = VehicleControlValidator.validateOdometer(odometer);
        Assertions.assertTrue(isValid);
    }

    @Test
    void validateOdometer_invalid(){
        int odometer = -110;
        Boolean isValid = VehicleControlValidator.validateOdometer(odometer);
        Assertions.assertFalse(isValid);
    }

    @Test
    void validateOdometer_invalid_equalsZero(){
        int odometer = 0;
        Boolean isValid = VehicleControlValidator.validateOdometer(odometer);
        Assertions.assertFalse(isValid);
    }

}
