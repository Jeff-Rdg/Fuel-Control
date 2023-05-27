package entitiesTest;

import org.jotasilva.validator.VehicleValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleValidatorTest {
    @Test
    void validatePlate_invalid(){
        String plate = "123-1234";

        boolean isValid = VehicleValidator.validatePlate(plate);

        Assertions.assertFalse(isValid);
    }

    @Test
    void validatePlate_Valid_oldplace(){
        String plate = "RIB-1234"; //padrão antigo

        boolean isValid = VehicleValidator.validatePlate(plate);

        Assertions.assertTrue(isValid);
    }

    @Test
    void validatePlate_Valid_newPlace(){
        String plate = "RIB-1H34";

        boolean isValid = VehicleValidator.validatePlate(plate);

        Assertions.assertTrue(isValid);
    }

    @Test
    void validatePlate_Invalid_newPlace(){
        String plate = "RIB-HH34";

        boolean isValid = VehicleValidator.validatePlate(plate);

        Assertions.assertFalse(isValid);
    }

    @Test
    void validatePlate_Invalid_oldPlace(){
        String plate = "RI1-1234";

        boolean isValid = VehicleValidator.validatePlate(plate);

        Assertions.assertFalse(isValid);
    }
}
