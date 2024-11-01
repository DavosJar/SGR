package com.app_rutas.controller.dao;

import com.app_rutas.controller.dao.implement.AdapterDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.Persona;
import com.app_rutas.models.Sexo;
import com.app_rutas.models.TipoIdentificacion;

public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;
    private LinkedList<Persona> listAll;
    
    public PersonaDao() {
        super(Persona.class);       
    }
    public Persona getPersona() {
        if(persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListAll() throws Exception {
        if(listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }
    public Boolean save() throws Exception {
        Integer id = listAll().getSize()+1;
        getPersona().setId(id);
        this.persist(this.persona);
        this.listAll = listAll();
        return true;
    }
    public Boolean update() throws Exception {
        this.merge(persona, persona.getId());
        this.listAll = listAll();
        return true;
    }
    public Boolean delete() throws Exception {
        this.delete(persona.getId());
        this.listAll = listAll();
        return true;
    }
        
    public String toJson() {
        return g.toJson(getPersona());
    }
    
    public Persona getPersonaById(Integer id) throws Exception {
        return get(id);
    }

    public String getPersonaJsonById(Integer id) throws Exception {
        return g.toJson(getPersonaById(id));
    }
    public TipoIdentificacion getTipos(String tipo) {
        return TipoIdentificacion.valueOf(tipo);
    }
    public TipoIdentificacion[] getTiposIdentificacion(){
        return TipoIdentificacion.values();
    }
    public Sexo getSexo(String sexo) {
        return Sexo.valueOf(sexo);
    }
    public Sexo[] getSexos(){
        return Sexo.values();
    }
}