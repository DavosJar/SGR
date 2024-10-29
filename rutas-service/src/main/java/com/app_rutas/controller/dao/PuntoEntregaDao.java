package com.app_rutas.controller.dao;
import com.app_rutas.controller.dao.implement.AdapterDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.PuntoEntrega;

public class PuntoEntregaDao extends AdapterDao<PuntoEntrega>{
    private PuntoEntrega puntoEntrega;
    private LinkedList<PuntoEntrega> listAlll;

    public PuntoEntregaDao(){
        super(PuntoEntrega.class);
    }

    public PuntoEntrega getPuntoEntrega() {
        return puntoEntrega;
    }

    public void setPuntoEntrega(PuntoEntrega puntoEntrega) {
        this.puntoEntrega = puntoEntrega;
    }

    public LinkedList<PuntoEntrega> getListAll() throws Exception{
        if (listAlll == null) {
            this.listAlll = listAll();
        }
        return listAlll;
    }

    public Boolean save() throws Exception{
        Integer id = listAll().getSize()+1;
        getPuntoEntrega().setIdPuntoEntrega(id);
        this.persist(this.puntoEntrega);
        this.listAlll = listAll();
        return true;
    }
    public String toJson(){
        return g.toJson(getPuntoEntrega());
    }

    public PuntoEntrega getPuntoEntregaById(Integer id)throws Exception{
        return get(id);
    }

    public String getPuntoEntregaJsonByID(Integer id)throws Exception{
        return g.toJson(getPuntoEntregaJsonByID(id));
    }
}
