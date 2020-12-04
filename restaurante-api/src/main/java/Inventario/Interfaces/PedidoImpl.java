/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario.Interfaces;

import Inventario.Pedidos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
public class PedidoImpl implements PedidoDao {
    @PersistenceContext(unitName = "ProyectoOptativaiiiPU")
     EntityManager em;
    @Override
    public List<Pedidos> encontrarTodosPedidos() {
        return em.createNamedQuery("Pedido.encontrarTodosPedidos").getResultList();
    }

    @Override
    public Pedidos encontrarPedidos(Pedidos pedido) {
        return em.find(Pedidos.class, pedido.getIdpedido());
    }

    @Override
    public void ingresarPedido(Pedidos pedido) {
        em.persist(pedido);
        em.flush();
    }

    @Override
    public void actualizarPedido(Pedidos pedido) {
        em.merge(pedido);
    }

    @Override
    public void eliminarPedido(Pedidos pedido) {
        em.remove(em.merge(pedido));
    }
    
    
}
