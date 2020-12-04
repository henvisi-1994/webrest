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
    @NamedQuery(name = "Cliente.encontrarTodosClientes", query = "SELECT cli FROM Clientes cli")
})
public class Clientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLI")
    private int idcli;
    @Column(name = "NOM_CLI")
    private String nomcli;
    @Column(name = "APE_CLI")
    private String apecli;
    @Column(name = "TEL_CLI")
    private String telcli;
    @Column(name = "DIR_CLI")
    private String dircli;

    public Clientes() {
    }

    public Clientes(int idcli) {
        this.idcli = idcli;
    }

    public Clientes(int idcli, String nomcli, String apecli, String telcli, String dircli) {
        this.idcli = idcli;
        this.nomcli = nomcli;
        this.apecli = apecli;
        this.telcli = telcli;
        this.dircli = dircli;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getApecli() {
        return apecli;
    }

    public void setApecli(String apecli) {
        this.apecli = apecli;
    }

    public String getTelcli() {
        return telcli;
    }

    public void setTelcli(String telcli) {
        this.telcli = telcli;
    }

    public String getDircli() {
        return dircli;
    }

    public void setDircli(String dircli) {
        this.dircli = dircli;
    }

    @Override
    public String toString() {
        return "Clientes{" + "idcli=" + idcli + ", nomcli=" + nomcli + ", apecli=" + apecli + ", telcli=" + telcli + ", dircli=" + dircli + '}';
    }

}
