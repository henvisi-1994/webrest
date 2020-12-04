/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion.Interfaces;
import java.util.List;
import Configuracion.Cargo;
/**
 *
 * @author Usuario
 */
public interface CargoDao {
        public List<Cargo> encontrarTodosCargo();
    
    public Cargo encontrarCargo(Cargo cargo);
    
    public void insertarCargo(Cargo cargo);
    
    public void actualizarCargo(Cargo cargo);
    
    public void eliminarCargo(Cargo cargo);
}
