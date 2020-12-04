/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Interfaces;
import java.util.List;
import Personas.Proveedor;
/**
 *
 * @author Usuario
 */
public interface ProveedorDao {
        public List<Proveedor> encontrarTodosProveedor();
    
    public Proveedor encontrarProveedor(Proveedor proveedor);
    
    public void insertarProveedor(Proveedor proveedor);
    
    public void actualizarProveedor(Proveedor proveedor);
    
    public void eliminarProveedor(Proveedor proveedor);
    
}
