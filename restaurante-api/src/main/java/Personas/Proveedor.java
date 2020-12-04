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
    @NamedQuery(name = "Proveedor.encontrarTodosProveedor", query = "SELECT prov FROM Proveedor prov")
})
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROV")
    private int idprov;
    @Column(name = "NOM_PROV")
    private String nomprov;
    @Column(name = "ID_LOCAL")
    private int idlocal;

    public Proveedor() {
    }

    public Proveedor(int idprov) {
        this.idprov = idprov;
    }

    public Proveedor(int idprov, String nomprov, int idlocal) {
        this.idprov = idprov;
        this.nomprov = nomprov;
        this.idlocal = idlocal;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }

    public String getNomprov() {
        return nomprov;
    }

    public void setNomprov(String nomprov) {
        this.nomprov = nomprov;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idprov=" + idprov + ", nomprov=" + nomprov + ", idlocal=" + idlocal + '}';
    }

}
