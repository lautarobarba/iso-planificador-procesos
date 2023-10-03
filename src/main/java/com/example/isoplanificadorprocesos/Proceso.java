package com.example.isoplanificadorprocesos;

public class Proceso {
    private String nombre;
    private Number tiempo_arribo;

    public Proceso(String nombre, Number tiempo_arribo){
        this.nombre = nombre;
        this.tiempo_arribo = tiempo_arribo;
    }

    @Override
    public String toString() {
        return nombre + ". TA:" + tiempo_arribo + ".";
    }
}
