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
public class ReciboPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRecibo")
    private int idRecibo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Encomienda_numero_guia")
    private int encomiendanumeroguia;

    public ReciboPK() {
    }

    public ReciboPK(int idRecibo, int encomiendanumeroguia) {
        this.idRecibo = idRecibo;
        this.encomiendanumeroguia = encomiendanumeroguia;
    }

    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public int getEncomiendanumeroguia() {
        return encomiendanumeroguia;
    }

    public void setEncomiendanumeroguia(int encomiendanumeroguia) {
        this.encomiendanumeroguia = encomiendanumeroguia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRecibo;
        hash += (int) encomiendanumeroguia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReciboPK)) {
            return false;
        }
        ReciboPK other = (ReciboPK) object;
        if (this.idRecibo != other.idRecibo) {
            return false;
        }
        if (this.encomiendanumeroguia != other.encomiendanumeroguia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.ReciboPK[ idRecibo=" + idRecibo + ", encomiendanumeroguia=" + encomiendanumeroguia + " ]";
    }
    
}
