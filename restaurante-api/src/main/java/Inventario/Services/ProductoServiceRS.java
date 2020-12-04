/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarioServices;


import Inventario.Interfaces.ProductoDao;
import Inventario.Producto;
import java.awt.PageAttributes;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Ricardo
 */
@Stateless
@Path("/Producto")
public class ProductoServiceRS {
    
    @Inject
    private ProductoDao interfazproducto;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Producto> listarProducto(){
        List<Producto> productos = interfazproducto.encontrarTodosProductos();
        System.out.println("Productos encontrados: "+productos);
        return productos;
    }
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_PRODUCTO}") 
    public Producto encontrarProducto(@PathParam("ID_PRODUCTO") int idproducto){
        Producto producto = interfazproducto.encontrarProducto(new Producto(idproducto));
        System.out.println("Producto encontrado: "+producto);
        return producto;
    }
    
    @POST
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    public Producto ingresarProducto(Producto producto){
        interfazproducto.ingresarProducto(producto);
        System.out.println("Producto agregado: "+producto);
        return producto;
    }
    
    @PUT
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_PRODUCTO}") 
    public Response actualizarProducto(@PathParam("ID_PRODUCTO") int idproducto, Producto productoModificado){
        Producto producto = interfazproducto.encontrarProducto(new Producto(idproducto));
        if(producto != null){
            interfazproducto.actualizarProducto(productoModificado);
            System.out.println("Producto actualizado: "+productoModificado);
            return Response.ok().entity(productoModificado).build();
        }else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{ID_PRODUCTO}") 
    public Response eliminarProducto(@PathParam("ID_PRODUCTO") int idproducto){
        interfazproducto.eliminarProducto(new Producto(idproducto));
        System.out.println("Producto eliminada: "+idproducto);
        return Response.ok().build();
    }
}
    

