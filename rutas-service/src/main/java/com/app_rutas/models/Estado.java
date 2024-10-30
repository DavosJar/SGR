package com.app_rutas.models;

public enum Estado {
    PLANTEADO("Planteado"),
    EN_DESARROLLO("En desarrollo"),
    EN_PRUEBAS("En pruebas"),
    IMPLEMENTADO("Implementado"),
    EN_OPERACION("En operación"),
    EN_MANTENIMIENTO("En mantenimiento"),
    EN_REVISION("En revisión"),
    FINALIZADO("Finalizado"),
    EN_DESUSO("En desuso");

    private final String descripcion;

    Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
