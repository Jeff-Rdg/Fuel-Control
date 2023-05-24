package org.jotasilva.entities;

import java.util.ArrayList;
import java.util.List;

public class Tank {
    private Long id;
    private Double capacity;
    private Double fuelQuantity = 0.0;
    private List<FuelTank> supplies = new ArrayList<>();

    private static Long next_id = 0L;
    public static Long getNextId(){
        return Tank.next_id++;
    }

    private Tank(Double capacity) {
        this.id = getNextId();
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public static Boolean isValidTank(Double capacity){
        return capacity > 0.0 && capacity < 50000.00;
    }

    public static Tank create(Double capacity) throws IllegalArgumentException{
        boolean isValid = isValidTank(capacity);
        if(isValid){
            return new Tank(capacity);
        }else {
            throw new IllegalArgumentException("Parâmetro inválido para criação do objeto.");
        }
    }
}
