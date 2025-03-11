package com.biblioteca.view;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.controller.TipoQuartoController;
import com.biblioteca.model.TipoQuarto;

public class TipoQuartoView {
    private TipoQuartoController tipoQuartoController;
    private Scanner scanner;

    public TipoQuartoView() {
        tipoQuartoController = new TipoQuartoController();
        scanner = new Scanner(System.in);
    }

    public void displayAllTipoQuartos() {
        List<TipoQuarto> tipoQuartos = tipoQuartoController.getAllTipoQuartos();
        for (TipoQuarto tipoQuarto : tipoQuartos) {
            System.out.println("ID: " + tipoQuarto.getIdTipo());
            System.out.println("Característica: " + tipoQuarto.getCaracteristica());
            System.out.println("Descrição: " + tipoQuarto.getDescricao());
            System.out.println("Capacidade: " + tipoQuarto.getCapacidade());
            System.out.println("Preço por Noite: " + tipoQuarto.getPrecoNoite());
            System.out.println("-----------------------------");
        }
    }

    public void addTipoQuarto() {
        System.out.println("Digite a característica:");
        String caracteristica = scanner.nextLine();
        System.out.println("Digite a descrição:");
        String descricao = scanner.nextLine();
        System.out.println("Digite a capacidade:");
        int capacidade = scanner.nextInt();
        System.out.println("Digite o preço por noite:");
        double precoNoite = scanner.nextDouble();
        scanner.nextLine();

        TipoQuarto tipoQuarto = new TipoQuarto(0, caracteristica, descricao, capacidade, precoNoite);
        tipoQuartoController.addTipoQuarto(tipoQuarto);
        System.out.println("Tipo de quarto adicionado com sucesso!");
    }

    public void updateTipoQuarto() {
        System.out.println("Digite o ID do tipo de quarto a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a nova característica:");
        String caracteristica = scanner.nextLine();
        System.out.println("Digite a nova descrição:");
        String descricao = scanner.nextLine();
        System.out.println("Digite a nova capacidade:");
        int capacidade = scanner.nextInt();
        System.out.println("Digite o novo preço por noite:");
        double precoNoite = scanner.nextDouble();
        scanner.nextLine();

        TipoQuarto tipoQuarto = new TipoQuarto(id, caracteristica, descricao, capacidade, precoNoite);
        tipoQuartoController.updateTipoQuarto(tipoQuarto);
        System.out.println("Tipo de quarto atualizado com sucesso!");
    }

    public void deleteTipoQuarto() {
        System.out.println("Digite o ID do tipo de quarto a ser deletado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        tipoQuartoController.deleteTipoQuarto(id);
        System.out.println("Tipo de quarto deletado com sucesso!");
    }

    public static void main(String[] args) {
        TipoQuartoView view = new TipoQuartoView();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Tipo de Quarto");
            System.out.println("2. Visualizar Todos os Tipos de Quarto");
            System.out.println("3. Atualizar Tipo de Quarto");
            System.out.println("4. Deletar Tipo de Quarto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    view.addTipoQuarto();
                    break;
                case 2:
                    view.displayAllTipoQuartos();
                    break;
                case 3:
                    view.updateTipoQuarto();
                    break;
                case 4:
                    view.deleteTipoQuarto();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}
