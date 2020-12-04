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
     @NamedQuery(name = "Pedido.encontrarTodosPedidos", query = "SELECT * FROM PEDIDOS ORDER BY ID_PEDIDO")
})
public class Pedidos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private int idpedido;
    @Column(name = "TIPO_PEDIDO")
    private String tipopedido;

    public Pedidos() {
    }

    public Pedidos(int idpedido, String tipopedido) {
        this.idpedido = idpedido;
        this.tipopedido = tipopedido;
    }

    public Pedidos(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public String getTipopedido() {
        return tipopedido;
    }

    public void setTipopedido(String tipopedido) {
        this.tipopedido = tipopedido;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "idpedido=" + idpedido + ", tipopedido=" + tipopedido + '}';
    }
    
}
