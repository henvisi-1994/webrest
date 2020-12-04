/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion.Interfaces;

import Configuracion.Telefono;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface TelefonoDao {
     public List<Telefono> encontrarTodosTelefonos();
    
    public Telefono encontrarTelefono(Telefono pedido);
    
    public void ingresarTelefono(Telefono pedido);
    
    public void actualizarTelefono(Telefono pedido);
    
    public void eliminarTelefono(Telefono pedido);
}
