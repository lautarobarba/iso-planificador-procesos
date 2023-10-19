package com.example.isoplanificadorprocesos;

public class Proceso {

    static int serial = 0;

    // Atributos
    private Number id;
    private String nombre;
    private Number tiempo_arribo;
    private Number cantidad_rafagas;
    private Number duracion_rafaga_cpu;
    private Number duracion_rafaga_io;
    private Number prioridad;

    // Estado (Resultados) del proceso finalizado
    private int tiempo_retorno = 0;
    private int tiempo_retorno_normalizado = 0;
    private int tiempo_en_estado_listo = 0;

    public Proceso(Number id, String nombre, Number tiempo_arribo, Number cantidad_rafagas, Number duracion_rafaga_cpu, Number duracion_rafaga_io, Number prioridad){
        this.id = id;
        this.nombre = nombre;
        this.tiempo_arribo = tiempo_arribo;
        this.cantidad_rafagas = cantidad_rafagas;
        this.duracion_rafaga_cpu = duracion_rafaga_cpu;
        this.duracion_rafaga_io = duracion_rafaga_io;
        this.prioridad = prioridad;
    }

    public static Number getNextID(){
        serial += 1;
        return serial;
    }
    @Override
    public String toString() {
        return this.nombre;
    }

    public void limpiarEstado(){
        // Limpio Estado/Resultados anteriores
        this.tiempo_retorno = 0;
        this.tiempo_retorno_normalizado = 0;
        this.tiempo_en_estado_listo = 0;
    }

    public Number getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Number getTiempoArribo(){
        return this.tiempo_arribo;
    }

    public Number getCantidadRafagas(){
        return this.cantidad_rafagas;
    }

    public Number getDuracionRafagaCPU(){
        return this.duracion_rafaga_cpu;
    }

    public Number getDuracionRafagaIO(){
        return this.duracion_rafaga_io;
    }

    public Number getPrioridad(){
        return this.prioridad;
    }
}
