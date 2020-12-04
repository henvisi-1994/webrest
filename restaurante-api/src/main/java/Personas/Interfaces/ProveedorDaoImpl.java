/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Interfaces;

import Personas.Interfaces.ProveedorDao;
import Personas.Proveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
public class ProveedorDaoImpl implements ProveedorDao {

    @PersistenceContext(unitName = "ProyectoOptativaiiiPU")
    EntityManager em;

    @Override
    public List<Proveedor> encontrarTodosProveedor() {
        return em.createNamedQuery("Proveedor.encontrarTodosProveedor").getResultList();
    }

    @Override
    public Proveedor encontrarProveedor(Proveedor proveedor) {
        return em.find(Proveedor.class, proveedor.getIdprov());
    }

    @Override
    public void insertarProveedor(Proveedor proveedor) {
        em.persist(proveedor);
        em.flush();
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) {
        em.merge(proveedor);
    }

    @Override
    public void eliminarProveedor(Proveedor proveedor) {
        em.remove(em.merge(proveedor));
    }

}
