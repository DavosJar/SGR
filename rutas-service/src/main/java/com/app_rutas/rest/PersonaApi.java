package com.app_rutas.rest;

import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.app_rutas.controller.dao.services.PersonaServices;
import com.app_rutas.controller.excepcion.ListEmptyException;
import com.app_rutas.models.Persona;

@Path("/persona")
public class PersonaApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAllPersonas() throws ListEmptyException, Exception {
        HashMap res = new HashMap<>(); 
        PersonaServices ps = new PersonaServices();
        try {
            res.put("status", "success");
            res.put("message", "Consulta realizada con éxito.");
            res.put("data", ps.listAll().toArray());
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", "Error interno del servidor: " + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getPersonaById(@PathParam("id") Integer id) {
        String jsonResponse = "";
        PersonaServices ps = new PersonaServices();
        try {
            jsonResponse = ps.getPersonaJsonById(id);
            return Response.ok(jsonResponse).build();
        } catch (Exception e) {
            HashMap res = new HashMap<>();
            res.put("status", "error");
            res.put("message", "Error interno del servidor: " + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap map) {
        HashMap res = new HashMap<>();
        PersonaServices ps = new PersonaServices();
        
        try {
            if (map.get("nombre") == null || map.get("nombre").toString().isEmpty()) {
                throw new IllegalArgumentException("El campo 'nombre' es obligatorio.");
            }
            ps.getPersona().setNombre(map.get("nombre").toString());
    
            if (map.get("apellido") == null || map.get("apellido").toString().isEmpty()) {
                throw new IllegalArgumentException("El campo 'apellido' es obligatorio.");
            }
            ps.getPersona().setApellido(map.get("apellido").toString());
    
            if (map.get("tipoIdentificacion") != null) {
                ps.getPersona().setTipoIdentificacion(ps.getTipos(map.get("tipoIdentificacion").toString()));
            }
            if (map.get("identificacion") != null) {
                ps.getPersona().setIdentificacion(map.get("identificacion").toString());
            }
            if (map.get("fechaNacimiento") != null) {
                ps.getPersona().setFechaNacimiento(map.get("fechaNacimiento").toString());
            }
            if (map.get("direccion") != null) {
                ps.getPersona().setDireccion(map.get("direccion").toString());
            }
            if (map.get("telefono") != null) {
                ps.getPersona().setTelefono(map.get("telefono").toString());
            }
            if (map.get("email") != null) {
                ps.getPersona().setEmail(map.get("email").toString());
            }
            if (map.get("sexo") != null) {
                ps.getPersona().setSexo(ps.getSexo(map.get("sexo").toString()));
            }
    
            ps.save();
            res.put("estado", "Ok");
            res.put("data", "Registro guardado con éxito.");
            return Response.ok(res).build();
        } catch (IllegalArgumentException e) {
            res.put("estado", "error");
            res.put("data", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        } catch (Exception e) {
            res.put("estado", "error");
            res.put("data", "Error interno del servidor: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/delete/")
    public Response delete(@PathParam("id") Integer id) {
        HashMap res = new HashMap<>();
        PersonaServices ps = new PersonaServices();
        try {
            ps.getPersona().setId(id);
            ps.delete();
            res.put("estado", "Ok");
            res.put("data", "Registro eliminado con exito.");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("estado", "error");
            res.put("data", "Error interno del servidor: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/update")
    public Response update(HashMap map, @PathParam("id") Integer id) {
        HashMap res = new HashMap<>();
        PersonaServices ps = new PersonaServices();
        try {
            Persona persona = ps.getPersonaById(id);
            if (persona == null) {
                throw new IllegalArgumentException("El registro no existe.");
            }
            if (map.get("nombre") != null) {
                persona.setNombre(map.get("nombre").toString());
            }
            if (map.get("apellido") != null) {
                persona.setApellido(map.get("apellido").toString());
            }
            if (map.get("tipoIdentificacion") != null) {
                persona.setTipoIdentificacion(ps.getTipos(map.get("tipoIdentificacion").toString()));
            }
            if (map.get("identificacion") != null) {
                persona.setIdentificacion(map.get("identificacion").toString());
            }
            if (map.get("fechaNacimiento") != null) {
                persona.setFechaNacimiento(map.get("fechaNacimiento").toString());
            }
            if (map.get("direccion") != null) {
                persona.setDireccion(map.get("direccion").toString());
            }
            if (map.get("telefono") != null) {
                persona.setTelefono(map.get("telefono").toString());
            }
            if (map.get("email") != null) {
                persona.setEmail(map.get("email").toString());
            }
            if (map.get("sexo") != null) {
                persona.setSexo(ps.getSexo(map.get("sexo").toString()));
            }
            ps.setPersona(persona);
            ps.update();
            res.put("estado", "Ok");
            res.put("data", "Registro actualizado con éxito.");
            return Response.ok(res).build();
        } catch (IllegalArgumentException e) {
            res.put("estado", "error");
            res.put("data", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
        } catch (Exception e) {
            res.put("estado", "error");
            res.put("data", "Error interno del servidor: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }  
    }
}
