package com.app_rutas.controller.dao;

import com.app_rutas.controller.dao.implement.AdapterDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.ConductorAsignado;
import com.app_rutas.models.Estado;

public class ConductorAsignadoDao extends AdapterDao<ConductorAsignado> {
    private ConductorAsignado conductorAsignado;
    private LinkedList<ConductorAsignado> listAll;
    public ConductorAsignadoDao() {
        super(ConductorAsignado.class);
    }

    public ConductorAsignado getConductorAsignado() {
        if(conductorAsignado == null) {
            conductorAsignado = new ConductorAsignado();
        }
        return conductorAsignado;
    }

    public void setConductorAsignado(ConductorAsignado conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    public LinkedList<ConductorAsignado> getListAll() throws Exception {
        if(listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize()+1;
        getConductorAsignado().setId(id);
        this.persist(this.conductorAsignado);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {
        this.merge(conductorAsignado, conductorAsignado.getId());
        this.listAll = listAll();
        return true;
    }

    public Boolean delete() throws Exception {
        this.delete(conductorAsignado.getId());
        this.listAll = listAll();
        return true;
    }

    public String toJson() {
        return g.toJson(getConductorAsignado());
    }
    
    public ConductorAsignado getConductorAsignadoById(Integer id) throws Exception {
        return get(id);
    }

    public String getConductorAsignadoJsonById(Integer id) throws Exception {
        return g.toJson(getConductorAsignadoById(id));
    }

    public String toJsonAll() throws Exception {
        return g.toJson(getListAll());
    }

    public Estado getEstado(String estado) {
        return Estado.valueOf(estado);
    }

    public Estado[] getEstados() {
        return Estado.values();
    }
    
}
