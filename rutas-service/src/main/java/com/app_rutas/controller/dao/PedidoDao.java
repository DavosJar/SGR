package com.app_rutas.controller.dao;

import com.app_rutas.controller.dao.implement.AdapterDao;
import com.app_rutas.controller.tda.list.LinkedList;
import com.app_rutas.models.Pedido;

public class PedidoDao extends AdapterDao<Pedido> {
    private Pedido pedido;
    private LinkedList<Pedido> listAll;

    public PedidoDao(){
        super(Pedido.class);
    }
    
    public Pedido getPedido(){
        return pedido;

    }
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }

    public LinkedList<Pedido> getListAll() throws Exception{
        if (listAll == null) {
            this.listAll = listAll();
            
        }
        return listAll;
    }

    public Boolean save() throws Exception{
        Integer id = listAll().getSize()+1;
        getPedido().setId(id);
        this.persist(this.pedido);
        this.listAll = listAll();
        return true;

    }

    public String toJson(){
        return g.toJson(getPedido());
    }
    
    public Pedido getPedidoById(Integer id) throws Exception{
        return get(id);
    }

    public String getPedidoJsonById(Integer id) throws Exception{
        return g.toJson(getPedidoJsonById(id));
    }
}
