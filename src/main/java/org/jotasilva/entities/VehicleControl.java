package org.jotasilva.entities;

import org.jotasilva.validator.VehicleControlValidator;
import java.time.LocalDate;
import java.util.Objects;

public class VehicleControl {
    private Long id;
    private Long vehicleId;
    private int odometer;
    private Double quantityLiters;
    private LocalDate provisionDate;
    private static Long next_id = 0L;

    private VehicleControl(Vehicle vehicle, int odometer, Double quantityLiters, LocalDate provisionDate) {
        this.id = getNextId();
        this.vehicleId = vehicle.getId();
        this.odometer = odometer;
        this.quantityLiters = quantityLiters;
        this.provisionDate = provisionDate;
    }

    //region Getters and Setters
    public static Long getNextId() {
        return VehicleControl.next_id++;
    }

    public Long getId() {
        return this.id;
    }

    public Long getVehicleId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleControl that = (VehicleControl) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static VehicleControl create(Vehicle vehicle, int odometer, Double quantity, LocalDate date) throws IllegalArgumentException {
        boolean isValid = VehicleControlValidator.isValidVehicleControl(odometer, quantity);
        if (isValid) {
            return new VehicleControl(vehicle, odometer, quantity, date);
        } else {
            throw new IllegalArgumentException("Parâmetro inválido para criação do objeto.");
        }
    }
}
