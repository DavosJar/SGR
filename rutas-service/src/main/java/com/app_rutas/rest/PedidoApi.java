package com.app_rutas.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.app_rutas.controller.dao.services.PedidoServices;
import com.app_rutas.controller.excepcion.ListEmptyException;
import com.app_rutas.models.Pedido;
import com.google.gson.Gson;

@Path("/pedido")
public class PedidoApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllPedido()throws ListEmptyException{
        String responseJson = "";
        PedidoServices pe = new PedidoServices();
        Gson gson = new Gson();
        try {
            responseJson = "{\"data\":\"succes!\",\"info\":" + 
            gson.toJson(pe.listAll().toArray()) + "}";            
        } catch (Exception e) {
            e.printStackTrace();
            responseJson = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        return Response.ok(responseJson).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
     public Response getPedidoById(@PathParam("id") Integer id) {
        String jsonResponse = "";
        PedidoServices pe = new PedidoServices();
        
        try {
            jsonResponse = "{\"data\":\"succes!\",\"info\":" + 
            pe.getPedidoJsonById(id) + "}";            
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }

        return Response.ok(jsonResponse).build();
    }

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Pedido map) {
        PedidoServices pe = new PedidoServices();
        pe.setPedido(map);;

        HashMap<String, String> res = new HashMap<>();
        try {
            if (pe.save()) {
                res.put("msg", "OK");
                res.put("data", "Pedido registrada correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "No se pudo registrar la pedido.");
                return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
            }
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createPedido")
    public Response createPedido(String json) {
        String jsonResponse = "";
        PedidoServices pe = new PedidoServices();
        Gson gson = new Gson();
        try {
            Pedido p = gson.fromJson(json,Pedido.class);
            pe.setPedido(p);
            pe.save();
            jsonResponse = "{\"data\":\"persona created!\",\"with info\":" 
            + pe.toJson() + "}";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        

        return Response.ok(jsonResponse).build();
    }
    
    
}
