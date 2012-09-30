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
public class AdministradorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdministrador")
    private int idAdministrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Trabajador_codigo")
    private int trabajadorcodigo;

    public AdministradorPK() {
    }

    public AdministradorPK(int idAdministrador, int trabajadorcodigo) {
        this.idAdministrador = idAdministrador;
        this.trabajadorcodigo = trabajadorcodigo;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getTrabajadorcodigo() {
        return trabajadorcodigo;
    }

    public void setTrabajadorcodigo(int trabajadorcodigo) {
        this.trabajadorcodigo = trabajadorcodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAdministrador;
        hash += (int) trabajadorcodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministradorPK)) {
            return false;
        }
        AdministradorPK other = (AdministradorPK) object;
        if (this.idAdministrador != other.idAdministrador) {
            return false;
        }
        if (this.trabajadorcodigo != other.trabajadorcodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.AdministradorPK[ idAdministrador=" + idAdministrador + ", trabajadorcodigo=" + trabajadorcodigo + " ]";
    }
    
}
