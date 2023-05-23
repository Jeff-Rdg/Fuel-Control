package org.jotasilva.entities;

import java.util.Objects;

public class Owner {
    private Long id;
    private String cnpj;
    private String corporateName;
    private static Long next_id = 0L;

    public static Long getNextId() {
        return Owner.next_id++;
    }

    public Owner(String cnpj, String corporateName) {
        this.id = getNextId();
        this.cnpj = cnpj;
        this.corporateName = corporateName;
    }

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Métodos de validação
    public Boolean validateCnpj() {
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
}
