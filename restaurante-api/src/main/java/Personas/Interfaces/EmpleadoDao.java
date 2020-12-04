/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas.Interfaces;
import java.util.List;
import Personas.Empleado;
/**
 *
 * @author Usuario
 */
public interface EmpleadoDao {
    public List<Empleado> encontrarTodosEmpleados();
    
    public Empleado encontrarEmpleado(Empleado empleado);
    
    public void insertarEmpleado(Empleado empleado);
    
    public void actualizarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Empleado empleado);
}
