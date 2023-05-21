package org.jotasilva.entities;

import java.time.LocalDate;
import java.util.Objects;

public class VehicleTank {
    private Long vehicle_id;
    private Long Tank_id;
    private LocalDate provisionDate;
    private Double odometer;
    private Double quantityLiters;

    public VehicleTank(Vehicle vehicle, Tank tank, LocalDate provisionDate, Double odometer, Double quantityLiters) {
        this.vehicle_id = vehicle.getId();
        Tank_id = tank.getId();
        this.provisionDate = provisionDate;
        this.odometer = odometer;
        this.quantityLiters = quantityLiters;
    }

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public Long getTank_id() {
        return Tank_id;
    }

    public LocalDate getProvisionDate() {
        return provisionDate;
    }

    public void setProvisionDate(LocalDate provisionDate) {
        this.provisionDate = provisionDate;
    }

    public Double getOdometer() {
        return odometer;
    }

    public void setOdometer(Double odometer) {
        this.odometer = odometer;
    }

    public Double getQuantityLiters() {
        return quantityLiters;
    }

    public void setQuantityLiters(Double quantityLiters) {
        this.quantityLiters = quantityLiters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleTank that = (VehicleTank) o;
        return Objects.equals(vehicle_id, that.vehicle_id) && Objects.equals(Tank_id, that.Tank_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle_id, Tank_id);
    }
}
