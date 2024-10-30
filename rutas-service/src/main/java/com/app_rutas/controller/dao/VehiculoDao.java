package com.app_rutas.controller.dao;


import com.app_rutas.controller.dao.implement.AdapterDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.Estado;
import com.app_rutas.models.Vehiculo;

public class VehiculoDao extends AdapterDao<Vehiculo> {
    private Vehiculo vehiculo;
    private LinkedList<Vehiculo> listAll;

    public VehiculoDao(){
        super(Vehiculo.class);
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    
    public LinkedList<Vehiculo> getListAll() throws Exception{
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception{
        Integer id = listAll().getSize()+1;
        getVehiculo().setId(id);
        this.persist(this.vehiculo);
        this.listAll = listAll();
        return true;
    }

    public String toJson(){
        return g.toJson(getVehiculo());
    }

    public Vehiculo getVehiculoById(Integer id) throws Exception{
        return get(id);
    }

    public String getVehiculoJsonById(Integer id) throws Exception{
        return g.toJson(getVehiculoJsonById(id));
    }

    public Estado getEstado(String estado){
        return Estado.valueOf(estado);
    }
    
    public Estado[] getEstado(){
        return Estado.values(); 
    }

}
