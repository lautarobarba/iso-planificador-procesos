package com.example.isoplanificadorprocesos;

import java.util.Scanner;

public class PlanificadorCLI {

    private static final int EXIT_OPTION = 0;
    private static void printMenu() {
        System.out.println("=> MENU");
        System.out.println("1) - Ejecutar utilizando FCFS (First Come First Served).");
        System.out.println("2) - Ejecutar utilizando PE (Prioridad Externa)");
        System.out.println("3) - Ejecutar utilizando RR (Round-Robin).");
        System.out.println("4) - Ejecutar utilizando SPN (Shortest Process Next).");
        System.out.println("5) - Ejecutar utilizando SRTN (Shortest Remaining Time Next).");
        System.out.println("0) - Salir.");
        System.out.print(">> Seleccione una opción: ");
    }

    public static void main(String[] args) {
       System.out.println("=== Ejecutando PlanificadorCLI ===");

       PPService pp_service = new PPService();
       pp_service.loadProcesos();

       int optionSelected = -1;
       Scanner input = new Scanner(System.in);
       while(optionSelected != EXIT_OPTION){
           printMenu();
           optionSelected = input.nextInt();
           if(optionSelected < 0 || optionSelected > 5){
               System.out.println("Opcion seleccionada Inválida.");
           } else {
               System.out.println("Opcion seleccionada: " + optionSelected);
               switch (optionSelected) {
                   case 1:
                       pp_service.ejecutarFCFS();
                       break;
                   case 2:
                       pp_service.ejecutarPE();
                       break;
                   case 3:
                       pp_service.ejecutarRR();
                       break;
                   case 4:
                       pp_service.ejecutarSPN();
                       break;
                   case 5:
                       pp_service.ejecutarSRTN();
                       break;
                   default:
                       System.out.println("Saliendo...");
                       break;
               }
           }
       }
       System.out.println("=== Programa finalizado ===");
    }
}
