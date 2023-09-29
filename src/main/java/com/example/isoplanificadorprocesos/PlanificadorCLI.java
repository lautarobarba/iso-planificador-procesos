package com.example.isoplanificadorprocesos;

public class PlanificadorCLI {
    public static void main(String[] args) {
       System.out.println("Ejecutando PlanificadorCLI");

       PPService pp_service = new PPService();
       pp_service.loadProcesos();

       System.out.println("Saliendo...");
    }
}
