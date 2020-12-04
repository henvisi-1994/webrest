/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarioServices;

import Inventario.Interfaces.PedidoDao;
import Inventario.Pedidos;
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
@Path("/Pedidos")
public class PedidosServiceRS {
    
    @Inject
    private PedidoDao interfazpedido;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Pedidos> ListarPedidos(){
        List<Pedidos> pedidos = interfazpedido.encontrarTodosPedidos();
        System.out.println("Pedidos encontrados: "+pedidos);
        return pedidos;
    }
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_PEDIDO}") 
    public Pedidos encontrarPedidos(@PathParam("ID_PEDIDO") int idpedido){
        Pedidos pedidos = interfazpedido.encontrarPedidos(new Pedidos(idpedido));
        System.out.println("Pedido encontrado: "+pedidos);
        return pedidos;
    }
    
    @POST
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    public Pedidos ingresarPedido(Pedidos pedido){
        interfazpedido.ingresarPedido(pedido);
        System.out.println("Pedido agregado: "+pedido);
        return pedido;
    }
    
    @PUT
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_PEDIDO}") 
    public Response actualizarPedido(@PathParam("ID_PEDIDO") int idpedido, Pedidos pedidoModificado){
        Pedidos pedidos = interfazpedido.encontrarPedidos(new Pedidos(idpedido));
        if(pedidos != null){
            interfazpedido.actualizarPedido(pedidoModificado);
            System.out.println("Pedido actualizado: "+pedidoModificado);
            return Response.ok().entity(pedidoModificado).build();
        }else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_PEDIDO}") 
    public Response eliminarPedido(@PathParam("ID_PEDIDO") int idpedido){
        interfazpedido.eliminarPedido(new Pedidos(idpedido));
        System.out.println("Pedido eliminada: "+idpedido);
        return Response.ok().build();
    }
    
}