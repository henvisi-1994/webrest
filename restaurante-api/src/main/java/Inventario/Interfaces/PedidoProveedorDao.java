/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario.Interfaces;

import Inventario.PedidoProveedor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PedidoProveedorDao {
  public List<PedidoProveedor> encontrarTodosPedidosProveedor();
    
    public PedidoProveedor encontrarPedidoProveedor(PedidoProveedor pedidoproveedor);
    
    public void ingresarPedidoProveedor(PedidoProveedor pedidoproveedor);
    
    public void actualizarPedidoProveedor(PedidoProveedor pedidoproveedor);
    
    public void eliminarPedidoProveedor(PedidoProveedor pedidoproveedor);   
}
