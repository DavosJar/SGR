package com.app_rutas.models;

public enum  Estado {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private String estado;

    Estado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
