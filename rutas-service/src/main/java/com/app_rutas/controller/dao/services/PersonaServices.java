package com.app_rutas.controller.dao.services;

import com.app_rutas.controller.dao.PersonaDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.Persona;

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
}
