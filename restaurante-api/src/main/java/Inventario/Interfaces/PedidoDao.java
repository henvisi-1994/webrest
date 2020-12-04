/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario.Interfaces;

import Inventario.Pedidos;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PedidoDao {
     public List<Pedidos> encontrarTodosPedidos();
    
    public Pedidos encontrarPedidos(Pedidos pedido);
    
    public void ingresarPedido(Pedidos pedido);
    
    public void actualizarPedido(Pedidos pedido);
    
    public void eliminarPedido(Pedidos pedido);
}
