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
public class ConductorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idConductor")
    private int idConductor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Trabajador_codigo")
    private int trabajadorcodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vehiculo_placa_numeros")
    private int vehiculoplacanumeros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Vehiculo_placa_letras")
    private String vehiculoplacaletras;

    public ConductorPK() {
    }

    public ConductorPK(int idConductor, int trabajadorcodigo, int vehiculoplacanumeros, String vehiculoplacaletras) {
        this.idConductor = idConductor;
        this.trabajadorcodigo = trabajadorcodigo;
        this.vehiculoplacanumeros = vehiculoplacanumeros;
        this.vehiculoplacaletras = vehiculoplacaletras;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getTrabajadorcodigo() {
        return trabajadorcodigo;
    }

    public void setTrabajadorcodigo(int trabajadorcodigo) {
        this.trabajadorcodigo = trabajadorcodigo;
    }

    public int getVehiculoplacanumeros() {
        return vehiculoplacanumeros;
    }

    public void setVehiculoplacanumeros(int vehiculoplacanumeros) {
        this.vehiculoplacanumeros = vehiculoplacanumeros;
    }

    public String getVehiculoplacaletras() {
        return vehiculoplacaletras;
    }

    public void setVehiculoplacaletras(String vehiculoplacaletras) {
        this.vehiculoplacaletras = vehiculoplacaletras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idConductor;
        hash += (int) trabajadorcodigo;
        hash += (int) vehiculoplacanumeros;
        hash += (vehiculoplacaletras != null ? vehiculoplacaletras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConductorPK)) {
            return false;
        }
        ConductorPK other = (ConductorPK) object;
        if (this.idConductor != other.idConductor) {
            return false;
        }
        if (this.trabajadorcodigo != other.trabajadorcodigo) {
            return false;
        }
        if (this.vehiculoplacanumeros != other.vehiculoplacanumeros) {
            return false;
        }
        if ((this.vehiculoplacaletras == null && other.vehiculoplacaletras != null) || (this.vehiculoplacaletras != null && !this.vehiculoplacaletras.equals(other.vehiculoplacaletras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.encoming.encoming.entity.ConductorPK[ idConductor=" + idConductor + ", trabajadorcodigo=" + trabajadorcodigo + ", vehiculoplacanumeros=" + vehiculoplacanumeros + ", vehiculoplacaletras=" + vehiculoplacaletras + " ]";
    }
    
}
