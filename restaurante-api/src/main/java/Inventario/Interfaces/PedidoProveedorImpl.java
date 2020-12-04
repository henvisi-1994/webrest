/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario.Interfaces;

import Inventario.PedidoProveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
public class PedidoProveedorImpl implements PedidoProveedorDao {
    @PersistenceContext(unitName = "ProyectoOptativaiiiPU")
     EntityManager em;
    
    @Override
    public List<PedidoProveedor> encontrarTodosPedidosProveedor() {
        return em.createNamedQuery("PedidoProveedor.encontrarTodosPedidosProveedor").getResultList();
    }

    @Override
    public PedidoProveedor encontrarPedidoProveedor(PedidoProveedor pedidoproveedor) {
        return em.find(PedidoProveedor.class, pedidoproveedor.getIddedidoprov());
    }

    @Override
    public void ingresarPedidoProveedor(PedidoProveedor pedidoproveedor) {
        em.persist(pedidoproveedor);
        em.flush();
    }

    @Override
    public void actualizarPedidoProveedor(PedidoProveedor pedidoproveedor) {
          em.merge(pedidoproveedor);
    }

    @Override
    public void eliminarPedidoProveedor(PedidoProveedor pedidoproveedor) {
        em.remove(em.merge(pedidoproveedor));
    }
}
