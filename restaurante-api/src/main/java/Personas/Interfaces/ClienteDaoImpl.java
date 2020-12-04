/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Interfaces;

import Personas.Clientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
public class ClienteDaoImpl implements ClienteDao {

    @PersistenceContext(unitName = "ProyectoOptativaiiiPU")
    EntityManager em;

    @Override
    public List<Clientes> encontrarTodosClientess() {
        return em.createNamedQuery("Cliente.encontrarTodosClientes").getResultList();
    }

    @Override
    public Clientes encontrarClientes(Clientes cliente) {
        return em.find(Clientes.class, cliente.getIdcli());
    }

    @Override
    public void insertarClientes(Clientes cliente) {
        em.persist(cliente);
        em.flush();
    }

    @Override
    public void actualizarClientes(Clientes cliente) {
        em.merge(cliente);
    }

    @Override
    public void eliminarClientes(Clientes cliente) {
        em.remove(em.merge(cliente));
    }

}
