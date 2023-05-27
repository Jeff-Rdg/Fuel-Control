package org.jotasilva.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuelValidator {
    // métodos de validação de atributos Fuel
    public static Boolean isValidFuel(Double unitPrice, Double quantity, String invoiceNumber) {
        return isPositive(unitPrice) && isPositive(quantity) && validateInvoiceNumber(invoiceNumber);
    }

    public static Boolean validateInvoiceNumber(String invoiceNumber) {
        String regex = "\\d{3}-\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(invoiceNumber);

        return matcher.matches();
    }

    public static Boolean isPositive(Double value) {
        return value > 0;
    }

    // pensar na validação da data.
    public static LocalDate convertStringToDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }



}
