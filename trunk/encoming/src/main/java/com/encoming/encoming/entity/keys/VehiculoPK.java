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
import javax.validation.constraints.Size;

/**
 *
 * @author juanmanuelmartinezromero
 */
@Embeddable
public class VehiculoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "placa_numeros")
    private int placaNumeros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "placa_letras")
    private String placaLetras;

    public VehiculoPK() {
    }

    public VehiculoPK(int placaNumeros, String placaLetras) {
        this.placaNumeros = placaNumeros;
        this.placaLetras = placaLetras;
    }

    public int getPlacaNumeros() {
        return placaNumeros;
    }

    public void setPlacaNumeros(int placaNumeros) {
        this.placaNumeros = placaNumeros;
    }

    public String getPlacaLetras() {
        return placaLetras;
    }

    public void setPlacaLetras(String placaLetras) {
        this.placaLetras = placaLetras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) placaNumeros;
        hash += (placaLetras != null ? placaLetras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoPK)) {
            return false;
        }
        VehiculoPK other = (VehiculoPK) object;
        if (this.placaNumeros != other.placaNumeros) {
            return false;
        }
        if ((this.placaLetras == null && other.placaLetras != null) || (this.placaLetras != null && !this.placaLetras.equals(other.placaLetras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.VehiculoPK[ placaNumeros=" + placaNumeros + ", placaLetras=" + placaLetras + " ]";
    }
    
}
