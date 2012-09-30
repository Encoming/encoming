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
public class TrabajadorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Persona_documento")
    private int personadocumento;

    public TrabajadorPK() {
    }

    public TrabajadorPK(int codigo, int personadocumento) {
        this.codigo = codigo;
        this.personadocumento = personadocumento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        hash += (int) codigo;
        hash += (int) personadocumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorPK)) {
            return false;
        }
        TrabajadorPK other = (TrabajadorPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.personadocumento != other.personadocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.TrabajadorPK[ codigo=" + codigo + ", personadocumento=" + personadocumento + " ]";
    }
    
}
