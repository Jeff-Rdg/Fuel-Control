package org.jotasilva.entities;

import java.time.LocalDate;
import java.util.Objects;


public class FuelTank {
    // o método que realiza o abastecimento do tanque gera o relacionamento entre as classes e cria o Objeto FuelTank
    private Long fuel_id;
    private Long tank_id;
    private LocalDate provisionDate;

    public FuelTank(Fuel fuel, Tank tank, LocalDate provisionDate) {
        this.fuel_id = fuel.getId();
        this.tank_id = tank.getId();
        this.provisionDate = provisionDate;
    }

    public Long getFuel() {
        return fuel_id;
    }

    public void setFuel(Fuel fuel) {
        this.fuel_id = fuel.getId();
    }

    public Long getTank() {
        return tank_id;
    }

    public void setTank(Tank tank) {
        this.tank_id = tank.getId();
    }

    public LocalDate getProvisionDate() {
        return provisionDate;
    }

    public void setProvisionDate(LocalDate provisionDate) {
        this.provisionDate = provisionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelTank fuelTank = (FuelTank) o;
        return Objects.equals(fuel_id, fuelTank.fuel_id) && Objects.equals(tank_id, fuelTank.tank_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuel_id, tank_id);
    }
}
