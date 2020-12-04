/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion.Interfaces;

import Configuracion.Cargo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
public class CargoDaoImpl implements CargoDao {

    @PersistenceContext(unitName = "ProyectoOptativaiiiPU")
    EntityManager em;

    @Override
    public List<Cargo> encontrarTodosCargo() {
        return em.createNamedQuery("Cargo.encontrarTodosCargo").getResultList();
    }

    @Override
    public Cargo encontrarCargo(Cargo cargo) {
        return em.find(Cargo.class, cargo.getIdcargo());
    }

    @Override
    public void insertarCargo(Cargo cargo) {
        em.persist(cargo);
        em.flush();
    }

    @Override
    public void actualizarCargo(Cargo cargo) {
        em.merge(cargo);
    }

    @Override
    public void eliminarCargo(Cargo cargo) {
        em.remove(em.merge(cargo));
    }

}
