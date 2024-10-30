package com.app_rutas.controller.dao.services;

import com.app_rutas.controller.dao.PedidoDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.Pedido;

public class PedidoServices {
    private PedidoDao obj;

    public PedidoServices(){
        this.obj = new PedidoDao();
    }

    public boolean save() throws Exception{
        return obj.save();
    }

    public LinkedList<Pedido> listAll()throws Exception{
        return obj.getListAll();
    }

    public Pedido getPedido(){
        return obj.getPedido();
    }

    public void setPedido(Pedido pedido){
        obj.setPedido(pedido);
    }

    public String toJson(){
        return obj.toJson();
    }

    public Pedido getPedidoById(Integer id) throws Exception{
        return obj.getPedidoById(id);
    }

    public String getPedidoJsonById(Integer id) throws Exception{
        return obj.getPedidoJsonById(id);
    }

}
