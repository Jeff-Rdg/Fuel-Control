package org.jotasilva.entities;

import org.jotasilva.validator.OwnerValidator;

import java.util.Objects;

public class Owner {
    private Long id;
    private String cnpj;
    private String corporateName;
    private static Long next_id = 0L;

    private Owner(String cnpj, String corporateName) {
        this.id = getNextId();
        this.cnpj = cnpj;
        this.corporateName = corporateName;
    }

    //region Getters and Setters
    public static Long getNextId() {
        return Owner.next_id++;
    }

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    //endregion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Owner create(String cnpj, String corporateName) throws IllegalArgumentException {
        boolean isValid = OwnerValidator.isValidOwner(cnpj, corporateName);

        if (isValid) {
            return new Owner(cnpj, corporateName);
        } else {
            throw new IllegalArgumentException("Parâmetros inválidos para criação do objeto. ");
        }
    }
}
