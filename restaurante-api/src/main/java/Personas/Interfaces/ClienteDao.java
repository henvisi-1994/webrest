/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Interfaces;
import Personas.Clientes;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ClienteDao {
    public List<Clientes> encontrarTodosClientess();
    
    public Clientes encontrarClientes(Clientes cliente);
    
    public void insertarClientes(Clientes cliente);
    
    public void actualizarClientes(Clientes cliente);
    
    public void eliminarClientes(Clientes cliente);
    
}
