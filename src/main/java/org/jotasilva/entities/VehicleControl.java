package org.jotasilva.entities;

import java.time.LocalDate;

public class VehicleControl {
    private Long id;
    private Long vehicleId;
    private int odometer;
    private Double quantityLiters;
    private LocalDate provisionDate;
    private static Long next_id = 0L;

    public VehicleControl( Vehicle vehicle, int odometer, Double quantityLiters, LocalDate provisionDate) {
        this.id = getNextId();
        this.vehicleId = vehicle.getId();
        this.odometer = odometer;
        this.quantityLiters = quantityLiters;
        this.provisionDate = provisionDate;
    }

    //region Getters and Setters
    public static Long getNextId(){
        return VehicleControl.next_id++;
    }
    public Long getId(){
        return this.id;
    }
    public Long getVehicleId(){
        return this.vehicleId;
    }
    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public Double getQuantityLiters() {
        return quantityLiters;
    }

    public void setQuantityLiters(Double quantityLiters) {
        this.quantityLiters = quantityLiters;
    }

    public LocalDate getProvisionDate() {
        return provisionDate;
    }

    public void setProvisionDate(LocalDate provisionDate) {
        this.provisionDate = provisionDate;
    }
    // endregion

}
