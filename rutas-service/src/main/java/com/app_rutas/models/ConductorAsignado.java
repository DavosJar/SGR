package com.app_rutas.models;

public class ConductorAsignado {
    public Integer id;
    public Integer idConductor;
    public Integer idVehiculo;
    public Integer idRuta;
    public String fechaAsignacion;
    public String fechaFinalizacion;
    public Estado estado;

    public ConductorAsignado() {
    }

    public ConductorAsignado(Integer idConductor, Integer idVehiculo, Integer idRuta, String fechaAsignacion, String fechaFinalizacion, Estado estado) {
        this.idConductor = idConductor;
        this.idVehiculo = idVehiculo;
        this.idRuta = idRuta;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }    

}
