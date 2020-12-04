/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion.Services;
import Configuracion.Cargo;
import Configuracion.Interfaces.CargoDao;
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
@Path("/cargos")
public class CargoServices {
      @Inject
    private CargoDao cargoDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Cargo> listarCargos(){
        List<Cargo> cargos =  cargoDao.encontrarTodosCargo();
        System.out.println("cargos encontradas:" + cargos);
        return cargos;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /cargos/{id}, ej. /cargos/1
    public Cargo encontrarCargo(@PathParam("id") int id){
        Cargo cargo = cargoDao.encontrarCargo(new Cargo(id));
        System.out.println("cargo encontrada:" + cargo);
        return cargo;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Cargo agregarCargo(Cargo cargo){
        cargoDao.insertarCargo(cargo);
        System.out.println("cargo agregada:" + cargo);
        return cargo;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarCargo(@PathParam("id") int id, Cargo cargoModificada){
        Cargo cargo = cargoDao.encontrarCargo( new Cargo(id));
        if(cargo != null){
            cargoDao.actualizarCargo(cargoModificada);
            System.out.println("cargo modificada:" + cargoModificada);
            return Response.ok().entity(cargoModificada).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarCargo(@PathParam("id") int id){
        cargoDao.eliminarCargo(new Cargo(id));
        System.out.println("cargo eliminada con el id:" + id);
        return Response.ok().build();
    }

}
