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
                    Proceso p_aux = new Proceso(tokens[0].trim(), Integer.parseInt(tokens[1].trim()));
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
}
