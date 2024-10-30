package com.app_rutas.controller.dao.services;

import com.app_rutas.controller.dao.VehiculoDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.Estado;
import com.app_rutas.models.Vehiculo;

public class VehiculoServices {
    private VehiculoDao obj;

    public VehiculoServices(){
        this.obj = new VehiculoDao();
    }

    public Boolean save() throws Exception{
        return obj.save();
    } 

    public LinkedList<Vehiculo> listAll() throws Exception{
        return obj.getListAll();
    }

    public Vehiculo getVehiculo(){
        return obj.getVehiculo();
    }

    public void setVehiculo(Vehiculo vehiculo){
        obj.setVehiculo(vehiculo);
    }

    public String toJson(){
        return obj.toJson();
    }

    public Vehiculo getVehiculoById(Integer id) throws Exception{
        return obj.getVehiculoById(id);
    }

    public String getVehiculoJsonByid(Integer id) throws Exception{
        return obj.getVehiculoJsonById(id);
    }
    
    public Estado getEstado(String estado) throws Exception {
        return obj.getEstado(estado);
    }


    public Estado[] getEstados(){
        return Estado.values();
    } 
}
