package validatorTest;

import org.jotasilva.validator.TankValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TankValidatorTest {
    @Test
    void isValidTank_with_arguments_valids(){
        Double value = 2500.00;

        boolean result = TankValidator.isValidTank(value);

        Assertions.assertTrue(result);
    }

    @Test
    void isValidTank_with_arguments_invalids(){
        Double value = -2500.00;

        boolean result = TankValidator.isValidTank(value);

        Assertions.assertFalse(result);
    }

    @Test
    void isValidTank_with_arguments_greater_than_established(){
        Double value = 50000.01;

        boolean result = TankValidator.isValidTank(value);

        Assertions.assertFalse(result);
    }
}
