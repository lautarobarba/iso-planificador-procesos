package com.example.isoplanificadorprocesos;

import javafx.scene.control.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class PPService {
    private ArrayList<Proceso> procesos = new ArrayList<>();
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

    public void ejecutarFCFS(){
        System.out.println("Ejecutando FCFS (First Come First Served)...");
    }

    public void ejecutarPE(){
        System.out.println("Ejecutando PE (Prioridad Externa)...");
    }

    public void ejecutarRR(){
        System.out.println("Ejecutando RR (Round-Robin)...");
    }

    public void ejecutarSPN(){
        System.out.println("Ejecutando SPN (Shortest Process Next)...");
    }

    public void ejecutarSRTN(){
        System.out.println("Ejecutando SRTN (Shortest Remaining Time Next)...");
    }
}
