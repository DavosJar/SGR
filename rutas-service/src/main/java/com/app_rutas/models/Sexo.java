package com.app_rutas.models;

public enum  Sexo {
    HOMBRE("Hombre"),
    MUJER("Mujer");

    @SuppressWarnings("FieldMayBeFinal")
    private String descripcion;

    private Sexo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
