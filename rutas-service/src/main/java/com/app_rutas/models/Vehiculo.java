package com.app_rutas.models;


public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String placa;
    private float capacidad;
    private int potencia;
    private float pesoMin;
    private float pesoMax;
    private boolean tieneRefrigeracion;
    private Estado estado;

    //constructor vacio
    public Vehiculo(){}


    //constructor 
    public Vehiculo(int id,String marca, String modelo, String placa, float capacidad, int potencia, float pesoMin, float pesoMax, boolean tieneRefrigeracion, String estado){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.capacidad = capacidad;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        this.tieneRefrigeracion = tieneRefrigeracion;
        setEstado(estado);
    }

    //Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public float getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public float getPesoMin() {
        return pesoMin;
    }
    public void setPesoMin(float pesoMin) {
        this.pesoMin = pesoMin;
    }
    public float getPesoMax() {
        return pesoMax;
    }
    public void setPesoMax(float pesoMax) {
        this.pesoMax = pesoMax;
    }
    public boolean isTieneRefrigeracion() {
        return tieneRefrigeracion;
    }
    public void setTieneRefrigeracion(boolean tieneRefrigeracion) {
        this.tieneRefrigeracion = tieneRefrigeracion;
    }
    
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        try {
            // Intenta buscar directamente por el nombre del enum
            this.estado = Estado.valueOf(estado.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Si falla, intenta buscar por la descripción
            this.estado = findEstadoByDescripcion(estado);
            if (this.estado == null) {
                throw new IllegalArgumentException("Estado inválido: debe ser un valor reconocido.");
            }
        }
    }
    
    private Estado findEstadoByDescripcion(String descripcion) {
        for (Estado est : Estado.values()) {
            if (est.getDescripcion().equalsIgnoreCase(descripcion)) {
                return est;
            }
        }
        return null;
    }
}
