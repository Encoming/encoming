/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encoming.encoming.entity.keys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Embeddable
public class ClientePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Persona_documento")
    private int personadocumento;

    public ClientePK() {
    }

    public ClientePK(int idCliente, int personadocumento) {
        this.idCliente = idCliente;
        this.personadocumento = personadocumento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getPersonadocumento() {
        return personadocumento;
    }

    public void setPersonadocumento(int personadocumento) {
        this.personadocumento = personadocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCliente;
        hash += (int) personadocumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.personadocumento != other.personadocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.ClientePK[ idCliente=" + idCliente + ", personadocumento=" + personadocumento + " ]";
    }
    
}
