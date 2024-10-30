package com.app_rutas.models;

public class Pedido {
    private int id;
    private int idCliente;
    private String contenido;
    private boolean requiereFrio;

    public Pedido(){}

    public Pedido(int id, int idCliente, String contenido, boolean RequiereFrio){


        this.id = id;
        this.idCliente = idCliente;
        this.contenido = contenido;
        this.requiereFrio = false;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public boolean isRequiereFrio() {
        return requiereFrio;
    }
    public void setRequiereFrio(boolean requiereFrio) {
        this.requiereFrio = requiereFrio;
    } 
    
}
