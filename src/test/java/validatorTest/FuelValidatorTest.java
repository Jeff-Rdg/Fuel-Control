package validatorTest;

import org.jotasilva.validator.FuelValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FuelValidatorTest {

    // validateInvoiceNumber
    @Test
    void validateInvoiceNumber_With_parameters_invalids() {
        // preparação
        String invoiceNumber = "aa-bbbbbbbb";
        // execução
        boolean result = FuelValidator.validateInvoiceNumber(invoiceNumber);
        // verificação
        Assertions.assertFalse(result);

    }

    @Test
    void validateInvoiceNumber_With_parameters_invoiceNumber_with_numbers_and_letters() {
        // preparação
        String invoiceNumber = "12a-123456789";
        // execução
        boolean result = FuelValidator.validateInvoiceNumber(invoiceNumber);
        // verificação
        Assertions.assertFalse(result);

    }

    @Test
    void validateInvoiceNumber_With_parameters_valids() {
        // preparação
        String invoiceNumber = "123-123456789";
        // execução
        boolean result = FuelValidator.validateInvoiceNumber(invoiceNumber);
        // verificação
        Assertions.assertTrue(result);

    }

    // Validar quantity e unitPrice
    @Test
    void isPositive_with_numbers_negatives() {
        Double unitPrice = -2.0;
        Double quantity = -5000.00;

        boolean result = FuelValidator.isPositive(unitPrice) && FuelValidator.isPositive(quantity);

        Assertions.assertFalse(result);
    }

    @Test
    void isPositive_with_numbers_positives() {
        Double unitPrice = 2.0;
        Double quantity = 5000.00;

        boolean result = FuelValidator.isPositive(unitPrice) && FuelValidator.isPositive(quantity);

        Assertions.assertTrue(result);
    }

    // FuelValid
    @Test
    void fuelValid_is_Valid() {
        Double unitPrice = 2.0;
        Double quantity = 5000.00;
        String invoiceNumber = "123-123456789";

        boolean result = FuelValidator.isValidFuel(unitPrice, quantity, invoiceNumber);

        Assertions.assertTrue(result);
    }

    @Test
    void fuelValid_is_inValid() {
        Double unitPrice = -2.0;
        Double quantity = -5000.00;
        String invoiceNumber = "123-12345678";

        boolean result = FuelValidator.isValidFuel(unitPrice, quantity, invoiceNumber);

        Assertions.assertFalse(result);
    }


}
