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

import com.app_rutas.controller.dao.services.PersonaServices;
import com.app_rutas.controller.excepcion.ListEmptyException;
import com.app_rutas.models.Persona;
import com.google.gson.Gson;

@Path("/persona")
public class PersonaApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllPersons() throws ListEmptyException {
        String responseJson = "";
        PersonaServices ps = new PersonaServices();
        Gson gson = new Gson();
        
        try {
            responseJson = "{\"data\":\"succes!\",\"info\":" + 
            gson.toJson(ps.listAll().toArray()) + "}";            
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
    public Response getPersonaById(@PathParam("id") Integer id) {
        String jsonResponse = "";
        PersonaServices ps = new PersonaServices();
        
        try {
            jsonResponse = "{\"data\":\"succes!\",\"info\":" + 
            ps.getPersonaJsonById(id) + "}";            
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
    public Response save(Persona map) {
        PersonaServices ps = new PersonaServices();
        ps.setPersona(map);

        HashMap<String, String> res = new HashMap<>();
        try {
            if (ps.save()) {
                res.put("msg", "OK");
                res.put("data", "Persona registrada correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "No se pudo registrar la persona.");
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
    @Path("/createPersona")
    public Response createPersona(String json) {
        String jsonResponse = "";
        PersonaServices ps = new PersonaServices();
        Gson gson = new Gson();
        try {
            Persona p = gson.fromJson(json,Persona.class);
            ps.setPersona(p);
            ps.save();
            jsonResponse = "{\"data\":\"persona created!\",\"with info\":" 
            + ps.toJson() + "}";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        

        return Response.ok(jsonResponse).build();
    }
}
