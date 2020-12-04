/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Services;

import Personas.Clientes;
import Personas.Interfaces.ClienteDao;
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
@Path("/clientes")
public class ClienteServiceRS {
    @Inject
    private ClienteDao clienteDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Clientes> listarClientess(){
        List<Clientes> empleados =  clienteDao.encontrarTodosClientess();
        System.out.println("empleados encontradas:" + empleados);
        return empleados;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /empleados/{id}, ej. /empleados/1
    public Clientes encontrarClientes(@PathParam("id") int id){
        Clientes empleado = clienteDao.encontrarClientes(new Clientes(id));
        System.out.println("empleado encontrada:" + empleado);
        return empleado;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Clientes agregarClientes(Clientes empleado){
        clienteDao.insertarClientes(empleado);
        System.out.println("empleado agregada:" + empleado);
        return empleado;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarClientes(@PathParam("id") int id, Clientes empleadoModificada){
        Clientes empleado = clienteDao.encontrarClientes( new Clientes(id));
        if(empleado != null){
            clienteDao.actualizarClientes(empleadoModificada);
            System.out.println("empleado modificada:" + empleadoModificada);
            return Response.ok().entity(empleadoModificada).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarClientes(@PathParam("id") int id){
        clienteDao.eliminarClientes(new Clientes(id));
        System.out.println("empleado eliminada con el id:" + id);
        return Response.ok().build();
    }
}
