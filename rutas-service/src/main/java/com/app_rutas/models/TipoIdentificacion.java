package com.app_rutas.models;

public enum TipoIdentificacion {
    DNI("Documento Nacional de Identidad"),
    PASAPORTE("Pasaporte"),
    CARNET_EXTRANJERO("Carnet de Extranjería");

    private String descripcion;

    private TipoIdentificacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
