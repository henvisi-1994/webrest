/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Empleado.encontrarTodosEmpleado", query = "SELECT emp FROM Empleado emp")
})
public class Empleado implements Serializable{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMP")
   private int idemp;
   @Column(name = "NOMBRE_EMP")
   private String nombreemp;
   @Column(name = "DIR_EMP")
   private String diremp;
   @Column(name = "TEL_EMP")
   private String telfemp;
   @Column(name = "ID_LOCAL")
   private int idlocal;
   @Column(name = "ID_USUARIO")
   private int idusuario;

    public Empleado() {
    }

    public Empleado(int idemp) {
        this.idemp = idemp;
    }

    public Empleado(int idemp, String nombreemp, String diremp, String telfemp, int idlocal, int idusuario) {
        this.idemp = idemp;
        this.nombreemp = nombreemp;
        this.diremp = diremp;
        this.telfemp = telfemp;
        this.idlocal = idlocal;
        this.idusuario = idusuario;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public String getNombreemp() {
        return nombreemp;
    }

    public void setNombreemp(String nombreemp) {
        this.nombreemp = nombreemp;
    }

    public String getDiremp() {
        return diremp;
    }

    public void setDiremp(String diremp) {
        this.diremp = diremp;
    }

    public String getTelfemp() {
        return telfemp;
    }

    public void setTelfemp(String telfemp) {
        this.telfemp = telfemp;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idemp=" + idemp + ", nombreemp=" + nombreemp + ", diremp=" + diremp + ", telfemp=" + telfemp + ", idlocal=" + idlocal + ", idusuario=" + idusuario + '}';
    }
    
    
   
}
