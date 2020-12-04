/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarioServices;
import Inventario.Interfaces.PedidoProveedorDao;
import Inventario.PedidoProveedor;
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
@Path("/PedidoProveedor")
public class PedidoProveedorServicesRS {
    
    @Inject
    private PedidoProveedorDao interfazpedidoproveedor;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<PedidoProveedor> listarPedidoProveedor(){
        List<PedidoProveedor> pedidoproveedor = interfazpedidoproveedor.encontrarTodosPedidosProveedor();
        System.out.println("PedidoProveedor encontrado: "+pedidoproveedor);
        return pedidoproveedor;
    }
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_DEDIDO_PROV}") 
    public PedidoProveedor encontrarPedidoProveedor(@PathParam("ID_DEDIDO_PROV") int idpedidoproveedor){
        PedidoProveedor pedidoproveedor = interfazpedidoproveedor.encontrarPedidoProveedor(new PedidoProveedor(idpedidoproveedor));
        System.out.println("PedidoProveedor encontrado: "+pedidoproveedor);
        return pedidoproveedor;
    }
    
    @POST
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    public PedidoProveedor ingresarPedidoProveedor(PedidoProveedor pedidoproveedor){
        interfazpedidoproveedor.ingresarPedidoProveedor(pedidoproveedor);
        System.out.println("PedidoProveedor agregado: "+pedidoproveedor);
        return pedidoproveedor;
    }
    
    @PUT
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_DEDIDO_PROV}") 
    public Response actualizarPedidoProveedor(@PathParam("ID_DEDIDO_PROV") int idpedidoproveedor, PedidoProveedor pedidoproveedorModificado){
        PedidoProveedor pedidoproveedor = interfazpedidoproveedor.encontrarPedidoProveedor(new PedidoProveedor(idpedidoproveedor));
        if(pedidoproveedor != null){
            interfazpedidoproveedor.actualizarPedidoProveedor(pedidoproveedorModificado);
            System.out.println("PedidoProveedor actualizado: "+pedidoproveedorModificado);
            return Response.ok().entity(pedidoproveedorModificado).build();
        }else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    @DELETE
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_DEDIDO_PROV}") 
    public Response eliminarPedidoProveedor(@PathParam("ID_DEDIDO_PROV") int idpedidoproveedor){
        interfazpedidoproveedor.eliminarPedidoProveedor(new PedidoProveedor(idpedidoproveedor));
        System.out.println("PedidoProveedor eliminada: "+idpedidoproveedor);
        return Response.ok().build();
    }
    
}
