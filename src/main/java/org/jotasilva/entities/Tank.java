package org.jotasilva.entities;

import java.util.ArrayList;
import java.util.List;

public class Tank {
    private Long id;
    private Double capacity;
    private Double fuelQuantity = 0.0;
    private List<FuelTank> supplies = new ArrayList<>();

    private static Long next_id;
    public static Long getNextId(){
        return Tank.next_id++;
    }

    public Tank(Double capacity) {
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
}
