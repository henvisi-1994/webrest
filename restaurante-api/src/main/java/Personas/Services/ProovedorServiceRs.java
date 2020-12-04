/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Services;

import Personas.Interfaces.ProveedorDao;
import Personas.Proveedor;
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

/**
 *
 * @author Usuario
 */
@Stateless
@Path("/proveedores")
public class ProovedorServiceRs {
    @Inject
    private ProveedorDao proveedorDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Proveedor> listarProveedors(){
        List<Proveedor> proveedores =  proveedorDao.encontrarTodosProveedor();
        System.out.println("proveedores encontradas:" + proveedores);
        return proveedores;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /proveedores/{id}, ej. /proveedores/1
    public Proveedor encontrarProveedor(@PathParam("id") int id){
        Proveedor proveedor = proveedorDao.encontrarProveedor(new Proveedor(id));
        System.out.println("proveedor encontrada:" + proveedor);
        return proveedor;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Proveedor agregarProveedor(Proveedor proveedor){
        proveedorDao.insertarProveedor(proveedor);
        System.out.println("proveedor agregada:" + proveedor);
        return proveedor;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarProveedor(@PathParam("id") int id, Proveedor proveedorModificada){
        Proveedor proveedor = proveedorDao.encontrarProveedor( new Proveedor(id));
        if(proveedor != null){
            proveedorDao.actualizarProveedor(proveedorModificada);
            System.out.println("proveedor modificada:" + proveedorModificada);
            return Response.ok().entity(proveedorModificada).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarProveedor(@PathParam("id") int id){
        proveedorDao.eliminarProveedor(new Proveedor(id));
        System.out.println("proveedor eliminada con el id:" + id);
        return Response.ok().build();
    }
}
