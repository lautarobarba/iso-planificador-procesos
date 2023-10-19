package com.example.isoplanificadorprocesos;

import javafx.scene.control.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class PPService {
    private ArrayList<Proceso> procesos = new ArrayList<>();

    /* - Tiempo que utiliza el sistema operativo para aceptar los nuevos procesos (TIP) */
    private int tip;

    /* - Tiempo que utiliza el sistema operativo para terminar los procesos (TFP) */
    private int tfp;

    /* - Tiempo de conmutación entre procesos (TCP) */
    private int tcp;

    /* - Quantum (si fuera necesario) */
    private int quantum;

    // Estado (Resultados) de la tanda
    private int tiempo_retorno_tanda = 0;
    private int tiempo_medio_retorno_tanda = 0;
    public void loadProcesos(){
        System.out.println("=> Cargando procesos");

        try {
            String file = "src/lista_procesos.txt";
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter("\n");
            String currentLine;
            while(scanner.hasNext()){
                currentLine = scanner.next();
                if(!currentLine.contains("#")) {
                    String[] tokens = currentLine.split(";");
                    Proceso p_aux = new Proceso(
                            Proceso.getNextID(),
                            tokens[0].trim(),
                            Integer.parseInt(tokens[1].trim()),
                            Integer.parseInt(tokens[2].trim()),
                            Integer.parseInt(tokens[3].trim()),
                            Integer.parseInt(tokens[4].trim()),
                            Integer.parseInt(tokens[5].trim())
                    );
                    System.out.println(p_aux);
                    this.procesos.add(p_aux);
                }
            }
            scanner.close();
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    public ArrayList<Proceso> getProcesos() {
        return this.procesos;
    }

    public void resetResultados(){
        // Inputs
        this.tip = 0;
        this.tfp = 0;
        this.tcp = 0;
        this.quantum = 0;

        // Output (Resultados) de la tanda
        this.tiempo_retorno_tanda = 0;
        this.tiempo_medio_retorno_tanda = 0;

        // Output (Resultados) de los procesos
        for(Proceso proc_aux :this.procesos) {
            proc_aux.limpiarEstado();
        }
    }

    public void ejecutarFCFS(){
        System.out.println("Ejecutando FCFS (First Come First Served)...");
    }

    public void ejecutarPE(){
        System.out.println("Ejecutando PE (Prioridad Externa)...");
    }

    public void ejecutarRR(){
        System.out.println("Ejecutando RR (Round-Robin)...");
        // CONTROLAR QUE EL QUANTUM SEA MAYOR A CERO O SINO TIRAR ERROR
    }

    public void ejecutarSPN(){
        System.out.println("Ejecutando SPN (Shortest Process Next)...");
    }

    public void ejecutarSRTN(){
        System.out.println("Ejecutando SRTN (Shortest Remaining Time Next)...");
    }
}
