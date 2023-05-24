package org.jotasilva.entities;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fuel {
    private Long id;
    private Double unitPrice;
    private Double quantity;
    private String invoiceNumber;

    private static Long next_id = 0L;

    public static Long getNextId() {
        return Fuel.next_id++;
    }

    private Fuel(Double unitPrice, Double quantity, String invoiceNumber) {
        this.id = getNextId();
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
    }

    public Long getId() {
        return id;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fuel fuel = (Fuel) o;
        return Objects.equals(id, fuel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // métodos de validação de atributos
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

    public static Fuel create(Double unitPrice, Double quantity, String invoiceNumber) throws IllegalArgumentException {
        boolean isValid = isValidFuel(unitPrice, quantity, invoiceNumber);

        if (isValid) {
            return new Fuel(unitPrice, quantity, invoiceNumber);
        } else {
            throw new IllegalArgumentException("Parâmetros inválidos para criação do objeto. ");
        }
    }
}
