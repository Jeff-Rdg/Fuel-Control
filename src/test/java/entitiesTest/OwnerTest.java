package entitiesTest;

import org.jotasilva.entities.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OwnerTest {
    @Test
    void validateCnpj_if_is_valid(){
        Owner owner = new Owner("58577114000189", "nome test");

        Boolean result = owner.validateCnpj();

        Assertions.assertTrue(result);
    }

    @Test
    void validateCnpj_with_invalid_caracteres(){
        Owner owner = new Owner("aaaaaaaaaaaaaa", "nome test");

        Boolean result = owner.validateCnpj();

        Assertions.assertFalse(result);
    }

    @Test
    void validateCnpj_with_invalid_numbers_equals(){
        Owner owner = new Owner("11111111111111", "nome test");

        Boolean result = owner.validateCnpj();

        Assertions.assertFalse(result);
    }
}
