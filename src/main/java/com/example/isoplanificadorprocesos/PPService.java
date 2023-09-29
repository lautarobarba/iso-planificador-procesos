package com.example.isoplanificadorprocesos;

import java.io.BufferedReader;
import java.io.FileReader;

class Proceso {
    private String nombre;

    public Proceso(String nombre){
        this.nombre = nombre;
    }
}
public class PPService {
    // private Array<Proceso> procesos = [];
    public void loadProcesos(){
        System.out.println("Cargando procesos...");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/lista_procesos.txt"));
            //while(reader.)
            String currentLine = reader.readLine();
            System.out.println(currentLine);
            reader.close();

        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }
}
