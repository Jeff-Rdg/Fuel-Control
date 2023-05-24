package entitiesTest;

import org.jotasilva.entities.Tank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TankTest {
    @Test
    void isValidTank_with_arguments_valids(){
        Double value = 2500.00;

        boolean result = Tank.isValidTank(value);

        Assertions.assertTrue(result);
    }

    @Test
    void isValidTank_with_arguments_invalids(){
        Double value = -2500.00;

        boolean result = Tank.isValidTank(value);

        Assertions.assertFalse(result);
    }

    @Test
    void isValidTank_with_arguments_greater_than_established(){
        Double value = 50000.01;

        boolean result = Tank.isValidTank(value);

        Assertions.assertFalse(result);
    }
}
