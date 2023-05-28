package org.jotasilva.entities;

import org.jotasilva.validator.OwnerValidator;
import java.util.Objects;

public class Owner {
    private Long id;
    private String cnpj;
    private String corporateName;
    private static Long next_id = 1L;

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
        String registerCnpj = OwnerValidator.formatCnpj(cnpj);
        boolean isValid = OwnerValidator.isValidOwner(registerCnpj, corporateName);
        // precisa-se verificar se já existem owner registrados com o cnpj informado - Verificar na service

        if (isValid) {
            return new Owner(registerCnpj, corporateName);
        } else {
            throw new IllegalArgumentException("Parâmetros inválidos para criação do objeto. ");
        }
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", corporateName='" + corporateName + '\'' +
                '}';
    }
}
