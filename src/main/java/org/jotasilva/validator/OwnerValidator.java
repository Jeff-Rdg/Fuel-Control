package org.jotasilva.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OwnerValidator {
    // Métodos de validação
    public static Boolean validateCnpj(String cnpj) {
        String validateCnpj = cnpj.replaceAll("[^0-9]", "");
        if (validateCnpj.length() != 14) {
            return false;
        }

        // verificar se digitos são iguais
        if (validateCnpj.matches("(\\d)\\1{13}$")) {
            return false;
        }

        // digitos verificadores do cpnj
        int digit1 = Character.getNumericValue(validateCnpj.charAt(12));
        int digit2 = Character.getNumericValue(validateCnpj.charAt(13));

        // calcular digitos verificadores
        int sum = 0;
        int var1 = 5;

        int index = 1;

        while (index <= 4) {
            sum += Integer.parseInt(validateCnpj.substring(index - 1, index)) * var1;
            index++;
            var1--;
        }

        int var2 = 9;

        while (index <= 12) {
            sum += Integer.parseInt(validateCnpj.substring(index - 1, index)) * var2;
            index++;
            var2--;
        }

        int rest = (sum % 11);
        int verificationDigit1 = (rest < 2) ? 0 : 11 - rest;

        index = 1;
        sum = 0;
        var1 = 6;

        while (index <= 5) {
            sum += Integer.parseInt(validateCnpj.substring(index - 1, index)) * var1;
            index++;
            var1--;
        }

        var2 = 9;

        while (index <= 13) {
            sum += Integer.parseInt(validateCnpj.substring(index - 1, index)) * var2;
            index++;
            var2--;
        }

        rest = sum % 11;
        int verificationDigit2 = (rest < 2) ? 0 : 11 - rest;

        return (verificationDigit1 == digit1 && verificationDigit2 == digit2);
    }

    public static Boolean validateCorporateName(String corporateName) {
        String regex = "^[A-Za-z0-9.&\\sáÁâÂéÉêÊíÍóÓôÔúÚãÃõÕçÇ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(corporateName);

        return matcher.matches();
    }

    public static Boolean isValidOwner(String cnpj, String corporateName){
        return validateCnpj(cnpj) && validateCorporateName(corporateName);
    }
}
