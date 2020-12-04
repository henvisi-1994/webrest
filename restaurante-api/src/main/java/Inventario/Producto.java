/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Ricardo
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Producto.encontrarTodosProductos", query = "SELECT prod FROM PRODUCTO prod")
})

public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private int idproducto;
    @Column(name = "PRECIO_PRODUCTO")
    private float precioproducto;
    @Column(name = "NOM_PRODUCTO")
    private String nomprod;
    @Column(name = "ID_LOCAL")
    private int idlocal;

    public Producto() {
    }

    public Producto(int idproducto, float precioproducto, String nomprod, int idlocal) {
        this.idproducto = idproducto;
        this.precioproducto = precioproducto;
        this.nomprod = nomprod;
        this.idlocal = idlocal;
    }

    public Producto(int idproducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public float getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(float precioproducto) {
        this.precioproducto = precioproducto;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", precioproducto=" + precioproducto + ", nomprod=" + nomprod + ", idlocal=" + idlocal + '}';
    }

    

}
