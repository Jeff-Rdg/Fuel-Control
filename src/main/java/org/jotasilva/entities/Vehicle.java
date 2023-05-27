package org.jotasilva.entities;

import org.jotasilva.entities.enums.VehicleType;

import java.util.Objects;

public class Vehicle {
    private Long id;
    private String plate;
    private VehicleType type;
    private Owner owner;

    private static Long next_id = 0L;

    public Vehicle( String plate, VehicleType type, Owner owner) {
        this.id = getNextId();
        this.plate = plate;
        this.type = type;
        this.owner = owner;
    }

    //region Getters and Setters
    public static Long getNextId(){
        return Vehicle.next_id++;
    }

    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    //endregion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
