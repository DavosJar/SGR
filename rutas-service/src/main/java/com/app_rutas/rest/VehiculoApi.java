package com.app_rutas.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.app_rutas.controller.dao.services.VehiculoServices;
import com.app_rutas.controller.excepcion.ListEmptyException;
import com.app_rutas.models.Vehiculo;
import com.app_rutas.models.Estado;
import com.google.gson.Gson;

@Path("/vehiculo")
public class VehiculoApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllVehiculo()throws ListEmptyException{
        String responseJson = "";
        VehiculoServices ve = new VehiculoServices();
        Gson gson = new Gson();

        try {
            responseJson = "{\"data\":\"succes!\",\"info\":" + 
            gson.toJson(ve.listAll().toArray()) + "}";            
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
    public Response getVehiculoById(@PathParam("id") Integer id) {
        VehiculoServices ve = new VehiculoServices();
        Gson gson = new Gson();
        
        try {
            Vehiculo vehiculo = ve.getVehiculoById(id);
            
            if (vehiculo == null) {
                // Retorna un error 404 si el vehículo no existe
                return Response.status(Status.NOT_FOUND)
                        .entity("{\"data\":\"ErrorMsg\",\"info\":\"Vehículo no encontrado\"}")
                        .build();
            }
            
            // Retorna el vehículo en formato JSON
            String jsonResponse = gson.toJson(vehiculo);
            return Response.ok("{\"data\":\"success!\",\"info\":" + jsonResponse + "}").build();
            
        } catch (Exception e) {
            e.printStackTrace();
            String errorResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + e.getMessage() + "\"}";
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
        }
    }

    
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Map<String, Object> map) {
        VehiculoServices ve = new VehiculoServices();
        HashMap<String, String> res = new HashMap<>();

        try {
            // Crear un nuevo Vehiculo y setear sus propiedades
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setId(Integer.parseInt(map.get("id").toString()));
            vehiculo.setMarca(map.get("marca").toString());
            vehiculo.setModelo(map.get("modelo").toString());
            vehiculo.setPlaca(map.get("placa").toString());
            vehiculo.setCapacidad(Float.parseFloat(map.get("capacidad").toString()));
            vehiculo.setPotencia(Integer.parseInt(map.get("potencia").toString()));
            vehiculo.setPesoMin(Float.parseFloat(map.get("pesoMin").toString()));
            vehiculo.setPesoMax(Float.parseFloat(map.get("pesoMax").toString()));
            vehiculo.setTieneRefrigeracion(Boolean.parseBoolean(map.get("tieneRefrigeracion").toString()));

            // Convertir el estado recibido al tipo Estado del enum
            String estado = map.get("estado").toString();
            vehiculo.setEstado(estado);

            // Guardar el Vehiculo
            ve.setVehiculo(vehiculo);
            if (ve.save()) {
                res.put("msg", "OK");
                res.put("data", "Vehiculo registrado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "No se pudo registrar el vehiculo.");
                return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
            }
        } catch (IllegalArgumentException e) {
            // Maneja la excepción para un estado inválido
            res.put("msg", "Error");
            res.put("data", "Estado inválido: " + e.getMessage());
            return Response.status(Status.BAD_REQUEST).entity(res).build();
        } catch (Exception e) {
            // Maneja cualquier otra excepción
            res.put("msg", "Error");
            res.put("data", e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createVehiculo")
    public Response createVehiuculo(String json) {
        String jsonResponse = "";
        VehiculoServices ve = new VehiculoServices();
        Gson gson = new Gson();
        try {
            Vehiculo p = gson.fromJson(json,Vehiculo.class);
            ve.setVehiculo(p);
            ve.save();
            jsonResponse = "{\"data\":\"persona created!\",\"with info\":" 
            + ve.toJson() + "}";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        

        return Response.ok(jsonResponse).build();
    }

    @GET
    @Path("/estados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstados() {
        VehiculoServices ve = new VehiculoServices();
        Estado[] estados = ve.getEstados();  
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(estados);

        return Response.ok(jsonResponse).build();
    }

}
