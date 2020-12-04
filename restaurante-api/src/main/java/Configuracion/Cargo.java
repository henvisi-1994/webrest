/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cargo.encontrarTodosCargo", query = "SELECT carg from Cargo carg")
})
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARGO")
    private int idcargo;
    @Column(name = "NOMBRE_CARGO")
    private String nombrecargo;

    public Cargo() {
    }

    public Cargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public Cargo(int idcargo, String nombrecargo) {
        this.idcargo = idcargo;
        this.nombrecargo = nombrecargo;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getNombrecargo() {
        return nombrecargo;
    }

    public void setNombrecargo(String nombrecargo) {
        this.nombrecargo = nombrecargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "idcargo=" + idcargo + ", nombrecargo=" + nombrecargo + '}';
    }

}
