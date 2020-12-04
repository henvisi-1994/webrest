/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion.Services;

import Configuracion.Interfaces.TelefonoDao;
import Configuracion.Telefono;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
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

/**
 *
 * @author Ricardo
 */
@Stateless
@Path("/Telefono")
public class TelefonoServicesRS {
    
    @Inject
    private TelefonoDao interfaztelefono;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Telefono> listarTelefono(){
        List<Telefono> telefono = interfaztelefono.encontrarTodosTelefonos();
        System.out.println("Telefonos encontrados: "+telefono);
        return telefono;
    }
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_TELEFONO}") 
    public Telefono encontrarTelefono(@PathParam("ID_TELEFONO") int idtelefono){
        Telefono telefono = interfaztelefono.encontrarTelefono(new Telefono(idtelefono));
        System.out.println("Telefono encontrado: "+telefono);
        return telefono;
    }
    
    @POST
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    public Telefono ingresarTelefono(Telefono telefono){
        interfaztelefono.ingresarTelefono(telefono);
        System.out.println("Telefono agregado: "+telefono);
        return telefono;
    }
    
    @PUT
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_TELEFONO}") 
    public Response actualizarTelefono(@PathParam("ID_TELEFONO") int idtelefono, Telefono telefonoModificado){
        Telefono telefono = interfaztelefono.encontrarTelefono(new Telefono(idtelefono));
        if(telefono != null){
            interfaztelefono.actualizarTelefono(telefonoModificado);
            System.out.println("Telefono actualizado: "+telefonoModificado);
            return Response.ok().entity(telefonoModificado).build();
        }else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_TELEFONO}") 
    public Response eliminarTelefono(@PathParam("ID_TELEFONO") int idtelefono){
        interfaztelefono.eliminarTelefono(new Telefono(idtelefono));
        System.out.println("Telefono eliminada: "+idtelefono);
        return Response.ok().build();
    }
}