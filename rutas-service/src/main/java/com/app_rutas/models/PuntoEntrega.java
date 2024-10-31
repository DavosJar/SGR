package com.app_rutas.models;

public class PuntoEntrega {
    private Integer idPuntoEntrega;
    private String ciudad;
    private Double latitud;
    private Double longitud;
    private String direccion;
    private String ubicacionActual;

    public PuntoEntrega(){
    }

    public PuntoEntrega(Integer idPuntoEntrega,String ciudad, Double latitud, Double longitud, String direccion, String ubicacionActual){
        this.idPuntoEntrega = idPuntoEntrega;
        this.ciudad = ciudad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.ubicacionActual = ubicacionActual;
    }

    public Integer getIdPuntoEntrega() {
        return this.idPuntoEntrega;
    }

    public void setIdPuntoEntrega(int idPuntoEntrega) {
        this.idPuntoEntrega = idPuntoEntrega;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getLatitud() {
        return this.latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return this.longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacionActual() {
        return this.ubicacionActual;
    }

    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }
}
