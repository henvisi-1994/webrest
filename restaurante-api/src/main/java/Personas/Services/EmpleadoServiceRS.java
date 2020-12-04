/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Services;

import Personas.Interfaces.EmpleadoDao;
import Personas.Empleado;
import Personas.Interfaces.EmpleadoDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("/empleados")
public class EmpleadoServiceRS {
    @Inject
    private EmpleadoDao empleadoDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Empleado> listarEmpleados(){
        List<Empleado> empleados =  empleadoDao.encontrarTodosEmpleados();
        System.out.println("empleados encontradas:" + empleados);
        return empleados;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /empleados/{id}, ej. /empleados/1
    public Empleado encontrarEmpleado(@PathParam("id") int id){
        Empleado empleado = empleadoDao.encontrarEmpleado(new Empleado(id));
        System.out.println("empleado encontrada:" + empleado);
        return empleado;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Empleado agregarEmpleado(Empleado empleado){
        empleadoDao.insertarEmpleado(empleado);
        System.out.println("empleado agregada:" + empleado);
        return empleado;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarEmpleado(@PathParam("id") int id, Empleado empleadoModificada){
        Empleado empleado = empleadoDao.encontrarEmpleado( new Empleado(id));
        if(empleado != null){
            empleadoDao.actualizarEmpleado(empleadoModificada);
            System.out.println("empleado modificada:" + empleadoModificada);
            return Response.ok().entity(empleadoModificada).build();
        }
        else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarEmpleado(@PathParam("id") int id){
        empleadoDao.eliminarEmpleado(new Empleado(id));
        System.out.println("empleado eliminada con el id:" + id);
        return Response.ok().build();
    }
}
