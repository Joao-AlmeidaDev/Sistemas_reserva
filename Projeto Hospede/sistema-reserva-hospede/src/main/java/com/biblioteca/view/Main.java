package com.biblioteca.view;

import java.util.Scanner;

public class Main {
    // Cores da estilização do Menu
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TipoQuartoView tipoQuartoView = new TipoQuartoView();
        QuartoView quartoView = new QuartoView();
        FuncionarioView funcionarioView = new FuncionarioView();
        HospedeView hospedeView = new HospedeView();
        ReservaView reservaView = new ReservaView();
        
        while (true) {
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(GREEN + "      Sistema de Gestão do Hotel  " + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(YELLOW + "1. Gerenciar Tipo de Quarto" + RESET);
            System.out.println(YELLOW + "2. Gerenciar Quartos" + RESET);
            System.out.println(YELLOW + "3. Gerenciar Funcionários" + RESET);
            System.out.println(YELLOW + "4. Gerenciar Hóspedes" + RESET);
            System.out.println(YELLOW + "5. Gerenciar Reservas" + RESET); 
            System.out.println(YELLOW + "0. Sair" + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.print(GREEN + "Escolha uma opção: " + RESET);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarTipoQuartos(tipoQuartoView, scanner);
                    break;
                case 2:
                    gerenciarQuartos(quartoView, scanner);
                    break;
                case 3:
                    gerenciarFuncionarios(funcionarioView, scanner);
                    break;
                case 4:
                    gerenciarHospedes(hospedeView, scanner);
                    break;
                case 5:
                    gerenciarReservas(reservaView, scanner); 
                    break;
                case 0:
                    System.out.println(RED + "Saindo..." + RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        }
    }

    private static void gerenciarReservas(ReservaView reservaView, Scanner scanner) {
        while (true) {
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(GREEN + "          Gerenciar Reservas          " + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(YELLOW + "1. Exibir todas as reservas" + RESET);
            System.out.println(YELLOW + "2. Adicionar reserva" + RESET);
            System.out.println(YELLOW + "3. Atualizar reserva" + RESET);
            System.out.println(YELLOW + "4. Deletar reserva" + RESET);
            System.out.println(YELLOW + "0. Voltar" + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.print(GREEN + "Escolha uma opção: " + RESET);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    reservaView.displayAllReservas();
                    break;
                case 2:
                    reservaView.addReserva();
                    break;
                case 3:
                    reservaView.updateReserva();
                    break;
                case 4:
                    reservaView.deleteReserva();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        }
    }

    private static void gerenciarFuncionarios(FuncionarioView funcionarioView, Scanner scanner) {
        while (true) {
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(GREEN + "        Gerenciar Funcionários        " + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(YELLOW + "1. Exibir todos os funcionários" + RESET);
            System.out.println(YELLOW + "2. Adicionar funcionário" + RESET);
            System.out.println(YELLOW + "3. Atualizar funcionário" + RESET);
            System.out.println(YELLOW + "4. Deletar funcionário" + RESET);
            System.out.println(YELLOW + "0. Voltar" + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.print(GREEN + "Escolha uma opção: " + RESET);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    funcionarioView.displayAllFuncionarios();
                    break;
                case 2:
                    funcionarioView.addFuncionario();
                    break;
                case 3:
                    funcionarioView.updateFuncionario();
                    break;
                case 4:
                    funcionarioView.deleteFuncionario();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        }
    }

    private static void gerenciarQuartos(QuartoView quartoView, Scanner scanner) {
        while (true) {
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(GREEN + "           Gerenciar Quartos          " + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(YELLOW + "1. Exibir todos os quartos" + RESET);
            System.out.println(YELLOW + "2. Adicionar quarto" + RESET);
            System.out.println(YELLOW + "3. Atualizar quarto" + RESET);
            System.out.println(YELLOW + "4. Deletar quarto" + RESET);
            System.out.println(YELLOW + "0. Voltar" + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.print(GREEN + "Escolha uma opção: " + RESET);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    quartoView.displayAllQuartos();
                    break;
                case 2:
                    quartoView.addQuarto();
                    break;
                case 3:
                    quartoView.updateQuarto();
                    break;
                case 4:
                    quartoView.deleteQuarto();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        }
    }

    private static void gerenciarHospedes(HospedeView hospedeView, Scanner scanner) {
        while (true) {
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(GREEN + "           Gerenciar Hóspedes         " + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(YELLOW + "1. Exibir todos os hóspedes" + RESET);
            System.out.println(YELLOW + "2. Adicionar hóspede" + RESET);
            System.out.println(YELLOW + "3. Atualizar hóspede" + RESET);
            System.out.println(YELLOW + "4. Deletar hóspede" + RESET);
            System.out.println(YELLOW + "0. Voltar" + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.print(GREEN + "Escolha uma opção: " + RESET);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    hospedeView.displayAllHospedes();
                    break;
                case 2:
                    hospedeView.addHospede();
                    break;
                case 3:
                    hospedeView.updateHospede();
                    break;
                case 4:
                    hospedeView.deleteHospede();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        }
    }

    private static void gerenciarTipoQuartos(TipoQuartoView tipoQuartoView, Scanner scanner) { 
        while (true) {
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(GREEN + "        Gerenciar Tipos de Quarto     " + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.println(YELLOW + "1. Exibir todos os tipos de quarto" + RESET);
            System.out.println(YELLOW + "2. Adicionar tipo de quarto" + RESET);
            System.out.println(YELLOW + "3. Atualizar tipo de quarto" + RESET);
            System.out.println(YELLOW + "4. Deletar tipo de quarto" + RESET);
            System.out.println(YELLOW + "0. Voltar" + RESET);
            System.out.println(BLUE + "======================================" + RESET);
            System.out.print(GREEN + "Escolha uma opção: " + RESET);
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tipoQuartoView.displayAllTipoQuartos();
                    break;
                case 2:
                    tipoQuartoView.addTipoQuarto();
                    break;
                case 3:
                    tipoQuartoView.updateTipoQuarto();
                    break;
                case 4:
                    tipoQuartoView.deleteTipoQuarto();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        }
    }
}
