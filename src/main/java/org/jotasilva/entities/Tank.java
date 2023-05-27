package org.jotasilva.entities;

import org.jotasilva.validator.TankValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tank {
    private Long id;
    private Double capacity;
    private Double fuelQuantity = 0.0;
    private List<Vehicle> vehiclesFueled = new ArrayList<>();

    private static Long next_id = 0L;

    private Tank(Double capacity) {
        this.id = getNextId();
        this.capacity = capacity;
    }
    // region Getters and Setters
    public static Long getNextId(){
        return Tank.next_id++;
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

    public List<Vehicle> getVehiclesFueled() {
        return vehiclesFueled;
    }
    // endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tank tank = (Tank) o;
        return Objects.equals(id, tank.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Tank create(Double capacity) throws IllegalArgumentException{
        boolean isValid = TankValidator.isValidTank(capacity);
        if(isValid){
            return new Tank(capacity);
        }else {
            throw new IllegalArgumentException("Parâmetro inválido para criação do objeto.");
        }
    }
}
