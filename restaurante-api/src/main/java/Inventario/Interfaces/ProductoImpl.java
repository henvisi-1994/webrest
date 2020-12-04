/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario.Interfaces;

import Inventario.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
public class ProductoImpl implements ProductoDao {
    @PersistenceContext(unitName = "ProyectoOptativaiiiPU")
     EntityManager em;
    
    
    @Override
    public List<Producto> encontrarTodosProductos() {
        return em.createNamedQuery("Producto.encontrarTodosProductos").getResultList();
    }

    @Override
    public Producto encontrarProducto(Producto producto) {
        return em.find(Producto.class, producto.getIdproducto());
    }

    @Override
    public void ingresarProducto(Producto producto) {
        em.persist(producto);
        em.flush();
    }

    @Override
    public void actualizarProducto(Producto producto) {
        em.merge(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        em.remove(em.merge(producto));
    }
}
