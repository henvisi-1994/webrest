/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario.Interfaces;

import Inventario.Producto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ProductoDao {
    public List<Producto> encontrarTodosProductos();
    
    public Producto encontrarProducto(Producto producto);
    
    public void ingresarProducto(Producto producto);
    
    public void actualizarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
    
}
