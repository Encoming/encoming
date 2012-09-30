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
public class CounterPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCounter")
    private int idCounter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Trabajador_codigo")
    private int trabajadorcodigo;

    public CounterPK() {
    }

    public CounterPK(int idCounter, int trabajadorcodigo) {
        this.idCounter = idCounter;
        this.trabajadorcodigo = trabajadorcodigo;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
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
        hash += (int) idCounter;
        hash += (int) trabajadorcodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CounterPK)) {
            return false;
        }
        CounterPK other = (CounterPK) object;
        if (this.idCounter != other.idCounter) {
            return false;
        }
        if (this.trabajadorcodigo != other.trabajadorcodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.CounterPK[ idCounter=" + idCounter + ", trabajadorcodigo=" + trabajadorcodigo + " ]";
    }
    
}
