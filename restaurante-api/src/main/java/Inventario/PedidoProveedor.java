/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

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
     @NamedQuery(name = "PedidoProveedor.encontrarTodosPedidosProveedor", query = "SELECT PEDIDO_PROVEEDOR.ID_DEDIDO_PROV, CANTIDAD_PEDIDO_PROV, FECHA_CADUCIDAD_PED_PROV, PROVEEDORES.ID_PROV, NOM_PROV, LOCAL.ID_LOCAL, DIR_LOCAL FROM PEDIDO_PROVEEDOR INNER JOIN LOCAL ON PEDIDO_PROVEEDOR.ID_LOCAL = LOCAL.ID_LOCAL INNER JOIN PROVEEDORES ON PEDIDO_PROVEEDOR.ID_PROV = PROVEEDORES.ID_PROV")
})
public class PedidoProveedor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEDIDO_PROV")
    private int iddedidoprov;
    @Column(name = "CANTIDAD_PEDIDO_PROV")
    private int cantidadpedidoprov;
    @Column(name = "FECHA_PEDIDO_PROV")
    private String fecha;
    @Column(name = "ID_PROV")
    private int idprov;
    @Column(name = "ID_LOCAL")
    private int idlocal;

    public PedidoProveedor() {
    }

    public PedidoProveedor(int iddedidoprov, int cantidadpedidoprov, String fecha, int idprov, int idlocal) {
        this.iddedidoprov = iddedidoprov;
        this.cantidadpedidoprov = cantidadpedidoprov;
        this.fecha = fecha;
        this.idprov = idprov;
        this.idlocal = idlocal;
    }

    public PedidoProveedor(int iddedidoprov) {
        this.iddedidoprov = iddedidoprov;
    }

     public int getIddedidoprov() {
        return iddedidoprov;
    }

    public void setIddedidoprov(int iddedidoprov) {
        this.iddedidoprov = iddedidoprov;
    }

    public int getCantidadpedidoprov() {
        return cantidadpedidoprov;
    }

    public void setCantidadpedidoprov(int cantidadpedidoprov) {
        this.cantidadpedidoprov = cantidadpedidoprov;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    @Override
    public String toString() {
        return "PedidoProveedor{" + "iddedidoprov=" + iddedidoprov + ", cantidadpedidoprov=" + cantidadpedidoprov + ", fecha=" + fecha + ", idprov=" + idprov + ", idlocal=" + idlocal + '}';
    }
    
    
}
