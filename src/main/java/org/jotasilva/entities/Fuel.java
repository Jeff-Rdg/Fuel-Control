package org.jotasilva.entities;

import java.util.Objects;

public class Fuel {
    private Long id;
    private Double unitPrice;
    private Double quantity;
    private String invoiceNumber;

    private static Long next_id;

    public static Long getNextId() {
        return Fuel.next_id++;
    }

    public Fuel(Double unitPrice, Double quantity, String invoiceNumber) {
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
}
