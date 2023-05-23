package org.jotasilva.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuelService {
    /*
    atributos que serão validados
        private Double unitPrice; -> não pode ser negativo
        Double quantity; -> não pode ser negativo
        String invoiceNumber; ->
    * */

    //Pensar em como realizar o retorno dessas funções

    // realizar retorno apenas dessa função
    public static Boolean fuelValid(Double unitPrice, Double quantity, String invoiceNumber){
        return isPositive(unitPrice) && isPositive(quantity) && validateInvoiceNumber(invoiceNumber);
    }

    public static Boolean validateInvoiceNumber(String invoiceNumber){
        String regex = "\\d{3}-\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(invoiceNumber);

        return matcher.matches();
    }

    public static Boolean isPositive(Double value){
        return value > 0;
    }
}
