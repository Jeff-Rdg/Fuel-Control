package servicesTest;

import org.jotasilva.entities.Fuel;
import org.jotasilva.services.FuelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FuelTest {

    // validateInvoiceNumber
    @Test
    void validateInvoiceNumber_With_parameters_invalids() {
        // preparação
        String invoiceNumber = "aa-bbbbbbbb";
        Fuel fuelTest = new Fuel(4.24, 5000.00, invoiceNumber);
        // execução
        boolean result = fuelTest.validateInvoiceNumber(invoiceNumber);
        // verificação
        Assertions.assertFalse(result);

    }

    @Test
    void validateInvoiceNumber_With_parameters_valids() {
        // preparação
        String invoiceNumber = "123-123456789";
        Fuel fuelTest = new Fuel(4.24, 5000.00, invoiceNumber);
        // execução
        boolean result = fuelTest.validateInvoiceNumber(invoiceNumber);
        // verificação
        Assertions.assertTrue(result);

    }

    // Validar quantity e unitPrice
    @Test
    void isPositive_with_numbers_negatives() {
        Double unitPrice = -2.0;
        String invoiceNumber = "123-123456789";
        Fuel fuelTest = new Fuel(unitPrice, -5000.00, invoiceNumber);

        boolean result = fuelTest.isPositive(fuelTest.getUnitPrice()) && fuelTest.isPositive(fuelTest.getQuantity());

        Assertions.assertFalse(result);
    }

    @Test
    void isPositive_with_numbers_positives() {
        Double unitPrice = 2.0;
        String invoiceNumber = "123-123456789";
        Fuel fuelTest = new Fuel(unitPrice, 5000.00, invoiceNumber);

        boolean result = fuelTest.isPositive(fuelTest.getUnitPrice()) && fuelTest.isPositive(fuelTest.getQuantity());

        Assertions.assertTrue(result);
    }

    // FuelValid
    @Test
    void fuelValid_is_Valid() {
        Double unitPrice = 2.0;
        Double quantity = 5000.00;
        String invoiceNumber = "123-123456789";
        Fuel fuelTest = new Fuel(unitPrice, quantity, invoiceNumber);

        boolean result = fuelTest.fuelValid();

        Assertions.assertTrue(result);
    }

    @Test
    void fuelValid_is_inValid() {
        Double unitPrice = -2.0;
        Double quantity = -5000.00;
        String invoiceNumber = "123-12345678";
        Fuel fuelTest = new Fuel(unitPrice, quantity, invoiceNumber);

        boolean result = fuelTest.fuelValid();

        Assertions.assertFalse(result);
    }

}
