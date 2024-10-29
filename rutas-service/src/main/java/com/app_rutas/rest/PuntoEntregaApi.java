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

import com.app_rutas.controller.dao.services.PuntoEntregaServices;
import com.app_rutas.controller.excepcion.ListEmptyException;
import com.app_rutas.models.PuntoEntrega;
import com.google.gson.Gson;

@Path("/punto-entrega")
public class PuntoEntregaApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllPuntos() throws ListEmptyException{
        String responseJson = "";
        PuntoEntregaServices pes = new PuntoEntregaServices();
        Gson gson = new Gson();

    try {
        responseJson = "{\"data\":\"succes!\",\"info\":" +
        gson.toJson(pes.listAll().toArray()) + "}";
        }catch (Exception e) {
            e.printStackTrace();
            responseJson = "{\"data\":\"succes!\",\"info\":" +
            e.getMessage() + "\"}";
        }
    return Response.ok(responseJson).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Response getPuntoEntregaById(@PathParam("id") Integer id){
        String jsonResponse = "";
        PuntoEntregaServices pes = new PuntoEntregaServices();
        try {
            jsonResponse = "{\"data\":\"succes!\",\"info\":" + 
            pes.gePuntoEntregaById(id) + "}";
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
    public Response save(PuntoEntrega map){
        PuntoEntregaServices pes = new PuntoEntregaServices();
        pes.setPuntoEntrega(map);

        HashMap<String, String> res = new HashMap<>();
        try {
            if (pes.save()) {
                res.put("msg","ok");
                res.put("data", "Punto de entrega registrado correctamente");
                return Response.ok(res).build();
            }else{
                res.put("msg", "error");
                res.put("data", "No se pudo registrar el punto de entrega");
                return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
            }
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", "No se pudo registrar el punto de entrega");
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createPuntoEntrega")
    public Response createPuntoEntrega(String json){
        String jsonResponse = "";
        PuntoEntregaServices pes = new PuntoEntregaServices();
        Gson gson = new Gson();
        try {
            PuntoEntrega p = gson.fromJson(json, PuntoEntrega.class);
            pes.setPuntoEntrega(p);
            pes.save();
            jsonResponse = "{\"data\":\"Punto entrega created!\",\"with info\":" 
            + pes.toJson() + "}"; 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        return Response.ok(jsonResponse).build();
    }
}
