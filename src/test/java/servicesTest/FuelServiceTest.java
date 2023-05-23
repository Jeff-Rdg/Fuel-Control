package servicesTest;

import org.jotasilva.services.FuelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FuelServiceTest {

    // validateInvoiceNumber
    @Test
    void validateInvoiceNumber_With_letters() {
        // preparação
        String invoiceNumber = "aa-bbbbbbbb";
        // execução
        boolean result = FuelService.validateInvoiceNumber(invoiceNumber);
        // verificação
        Assertions.assertFalse(result);

    }

    @Test
    void validateInvoiceNumber_With_Numbers_And_Quantity_Correct() {
        // preparação
        String invoiceNumber = "123-123456789";
        // execução
        boolean result = FuelService.validateInvoiceNumber(invoiceNumber);
        // verificação
        Assertions.assertTrue(result);

    }

    // Validar quantity e unitPrice
    @Test
    void isPositive_with_numbers_negatives(){
        Double negative = -2.0;
        boolean result = FuelService.isPositive(negative);
        Assertions.assertFalse(result);
    }

    @Test
    void isPositive_with_numbers_positives(){
        Double negative = 2.0;
        boolean result = FuelService.isPositive(negative);
        Assertions.assertTrue(result);
    }

    // FuelValid
    @Test
    void fuelValid_is_Valid(){
        Double unitPrice = 25.0;
        Double quantity = 5.09;
        String invoiceNumber = "123-123456789";

        boolean result = FuelService.fuelValid(unitPrice,quantity,invoiceNumber);

        Assertions.assertTrue(result);
    }

    @Test
    void fuelValid_is_inValid(){
        Double unitPrice = 25.0;
        Double quantity = 5.09;
        String invoiceNumber = "123-12345678";

        boolean result = FuelService.fuelValid(unitPrice,quantity,invoiceNumber);

        Assertions.assertFalse(result);
    }

}
