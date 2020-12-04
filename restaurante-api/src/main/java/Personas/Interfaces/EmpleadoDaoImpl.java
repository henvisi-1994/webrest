/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Interfaces;

import Personas.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
public class EmpleadoDaoImpl implements EmpleadoDao{
    @PersistenceContext (unitName = "ProyectoOptativaiiiPU")
    EntityManager em;   
    @Override
    public List<Empleado> encontrarTodosEmpleados() {
        return em.createNamedQuery("Empleado.encontrarTodosEmpleado").getResultList();
    }

    @Override
    public Empleado encontrarEmpleado(Empleado empleado) {
         return em.find(Empleado.class, empleado.getIdemp());
    }

    @Override
    public void insertarEmpleado(Empleado empleado) {
        em.persist(empleado);
        em.flush();
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        em.merge(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        em.remove(em.merge(empleado));
    }
    
}
