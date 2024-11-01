package com.app_rutas.controller.dao.services;

import com.app_rutas.controller.dao.PersonaDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.Persona;
import com.app_rutas.models.Sexo;
import com.app_rutas.models.TipoIdentificacion;

public class PersonaServices {
    private PersonaDao obj;
    public PersonaServices() {
        this.obj = new PersonaDao();
    }
    public Boolean save() throws Exception {
        return obj.save();
    }

    public LinkedList<Persona> listAll() throws Exception {
        return obj.getListAll();
    }

    public Persona getPersona() {
        return obj.getPersona();
    }

    public void setPersona(Persona persona) {
        obj.setPersona(persona);
    }

    public String toJson() {
        return obj.toJson();
    }

    public Persona getPersonaById(Integer id) throws Exception  {
        return obj.getPersonaById(id);
    }

    public String getPersonaJsonById(Integer id) throws Exception {
        return obj.getPersonaJsonById(id);
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete() throws Exception {
        return obj.delete();
    }

    public TipoIdentificacion getTipos(String tipo) {
        return obj.getTipos(tipo);
    }
    public TipoIdentificacion[] getTipos() {
        return TipoIdentificacion.values();
    }

    public Sexo getSexo(String sexo) {
        return Sexo.valueOf(sexo);
    }
    public Sexo[] getSexos() {
        return Sexo.values();
    }

}
