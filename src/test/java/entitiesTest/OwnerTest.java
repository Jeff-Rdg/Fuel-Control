package entitiesTest;

import org.jotasilva.entities.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OwnerTest {
    @Test
    void validateCnpj_if_is_valid() {
        String cnpj = "58577114000189";

        Boolean result = Owner.validateCnpj(cnpj);

        Assertions.assertTrue(result);
    }

    @Test
    void validateCnpj_if_is_valid_with_numbers_repeat() {
        String cnpj = "47.333.905/0001-47";

        Boolean result = Owner.validateCnpj(cnpj);

        Assertions.assertTrue(result);
    }

    @Test
    void validateCnpj_with_invalid_caracteres() {
        String cnpj = "aaaaaaaaaaaaaa";

        Boolean result = Owner.validateCnpj(cnpj);

        Assertions.assertFalse(result);
    }

    @Test
    void validateCnpj_with_invalid_numbers_equals() {
        String cnpj = "11111111111111";

        Boolean result = Owner.validateCnpj(cnpj);

        Assertions.assertFalse(result);
    }

    // validar razao social
    @Test
    void validateCorporateName_with_valid_name() {
        String corporateName = "Bento e Kauê Locações de Automóveis Ltda";

        Boolean result = Owner.validateCorporateName(corporateName);

        Assertions.assertTrue(result);
    }

    @Test
    void validateCorporateName_with_invalid_name() {
        String corporateName = "Bento! e Kauê Locações de Automóveis Ltda";

        Boolean result = Owner.validateCorporateName(corporateName);

        Assertions.assertFalse(result);
    }
}
