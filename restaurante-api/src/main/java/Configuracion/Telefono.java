/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Ricardo
 */
@Entity
@NamedQueries({
     @NamedQuery(name = "Telefono.encontrarTodosTelefonos", query = "SELECT TELEFONO.ID_TELEFONO, NUMERO_TELF, LOCAL.ID_LOCAL, DIR_LOCAL FROM TELEFONO INNER JOIN LOCAL ON TELEFONO.ID_LOCAL = LOCAL.ID_LOCAL")
})
public class Telefono implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TELEFONO")
    private String numerotelef;
    private int idtelefono;
    private int idlocal;

    public Telefono() {
    }

    public Telefono(String numerotelef, int idtelefono, int idlocal) {
        this.numerotelef = numerotelef;
        this.idtelefono = idtelefono;
        this.idlocal = idlocal;
    }

    public Telefono(int idtelefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNumerotelef() {
        return numerotelef;
    }

    public void setNumerotelef(String numerotelef) {
        this.numerotelef = numerotelef;
    }

    public int getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(int idtelefono) {
        this.idtelefono = idtelefono;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    @Override
    public String toString() {
        return "Telefono{" + "numerotelef=" + numerotelef + ", idtelefono=" + idtelefono + ", idlocal=" + idlocal + '}';
    }
}
