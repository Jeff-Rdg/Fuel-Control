package org.jotasilva.entities;

import org.jotasilva.validator.FuelValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fuel {
    private Long id;
    private Double unitPrice;
    private Double quantity;
    private String invoiceNumber;
    private LocalDate provisionDate;
    private List<Tank> tanksFueled = new ArrayList<>();

    private static Long next_id = 0L;

    private Fuel(Double unitPrice, Double quantity, String invoiceNumber, LocalDate provisionDate) {
        this.id = getNextId();
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
        this.provisionDate = provisionDate;
    }

    //region Getters and Setters
    public static Long getNextId() {
        return Fuel.next_id++;
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

    public LocalDate getProvisionDate() {
        return provisionDate;
    }

    public void setProvisionDate(LocalDate provisionDate) {
        this.provisionDate = provisionDate;
    }

    public List<Tank> getTanksFueled() {
        return tanksFueled;
    }
    //endregion
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

    public static Fuel create(Double unitPrice, Double quantity, String invoiceNumber, LocalDate provisionDate) throws IllegalArgumentException {
        boolean isValid = FuelValidator.isValidFuel(unitPrice, quantity, invoiceNumber);

        if (isValid) {
            return new Fuel(unitPrice, quantity, invoiceNumber, provisionDate);
        } else {
            throw new IllegalArgumentException("Parâmetros inválidos para criação do objeto. ");
        }
    }
}
