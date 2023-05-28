package org.jotasilva;

import org.jotasilva.entities.Owner;
import java.util.Scanner;

public class Menu {
    static void exibirMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("Informe a Operação que deseja realizar: ");
        System.out.println("1 - Cadastrar Fornecedor. ");
        System.out.println("2 - Cadastrar Tanque de Abastecimento. ");
        System.out.println("3 - Cadastrar Veículo. ");
        System.out.println("4 - Cadastrar Nota Fiscal de Combustível. ");
        System.out.println("5 - Abastecer Tanque de Abastecimento. ");
        System.out.println("6 - Abastecer Veículo. ");
        System.out.println("0 - Sair. ");
        actions();
    }

    static void actions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Opção desejada: ");
        int value = scanner.nextInt();
        switch (value) {
            case 0:
                System.out.println("Até breve!");
                break;
            case 1:
                registerOwner();
                break;
            default:
                System.out.println("Operação inválida, tente novamente");
                actions();
        }
        scanner.close();
    }

    static void registerOwner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("Registrar Fornecedor:");

        System.out.print("Informe o CNPJ: ");
        String cnpj = scanner.nextLine();

        System.out.print("Informe a Razão Social: ");
        String corporateName = scanner.nextLine();

        Owner owner = Owner.create(cnpj, corporateName);
        // Após isso, envia para classe de serviço para ocorrer a persistencia dos dados.

        // teste para verificar os dados do owner
        System.out.println(owner);
        System.out.println();

        exibirMenu();
        scanner.close();
    }

}
